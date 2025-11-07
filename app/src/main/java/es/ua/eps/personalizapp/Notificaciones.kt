package es.ua.eps.personalizapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import es.ua.eps.personalizapp.databinding.NotificacionesBinding
import es.ua.eps.personalizapp.databinding.ToastLayoutBinding

class Notificaciones : AppCompatActivity() {
    private lateinit var bindings : NotificacionesBinding

    // Barra notificaciones
    //private val permission = android.Manifest.permission.POST_NOTIFICATIONS
    private val REQUEST_PERMISSION_CODE = 1
    private val CHANNEL_ID = "canal_taeras"
    private val NOTIF_ID = 10
    private var contTareas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel()
        pedirPermisoNotificaciones()
        initUI()
    }
    private fun initUI(){
        bindings = NotificacionesBinding.inflate(layoutInflater)
        with(bindings){
            setContentView(root)

            buttonToast.setOnClickListener {
                showToast(editTextToast.text.toString())
                editTextToast.setText("")
            }
            buttonSnack.setOnClickListener {
                showSnack(it, editTextSnack.text.toString())
                editTextSnack.setText("")
            }
            //Selection dialogues
            buttonColor.setOnClickListener { showColor() }
            buttonTamanyo.setOnClickListener { showTamanyo() }
            // Barra de estado
            buttonIniciar.setOnClickListener { showIniciar() }
            buttonDetener.setOnClickListener { showDetener() }
        }
    }
    private fun showToast(mensaje : String){
        val m = mensaje.ifEmpty { getString(R.string.hintEscribe) }

        val toastBinding = ToastLayoutBinding.inflate(layoutInflater) // inflate custom Toast
        toastBinding.txtMensaje.text = m

        val t = Toast(this@Notificaciones)
        t.duration = Toast.LENGTH_SHORT
        t.view = toastBinding.root
        if (Build.VERSION.SDK_INT < 30) {
            t.setGravity(Gravity.CENTER or Gravity.START, 0, 0)
        } else {
            t.setGravity(Gravity.CENTER, 0, 0)
        }
        t.show()
    }

    private fun showSnack(it: View, mensaje: String){
        if (mensaje.isEmpty()){
            Snackbar.make(it, getString(R.string.hintEscribe), Snackbar.LENGTH_SHORT).show()
        }
        else { // Add task
            val listaTareasOriginal = bindings.textViewTareas.text.toString()
            bindings.textViewTareas.append("\n"+mensaje)
            Snackbar.make(it, "Tarea añadida", Snackbar.LENGTH_LONG)
                .setAction("Deshacer"){
                    bindings.textViewTareas.setText(listaTareasOriginal)
                }.show()
        }
    }
    private fun showColor(){
        val items = arrayOf("Blanco y Negro", "Negro y Blanco", "Negro y Verde")
        AlertDialog.Builder(this@Notificaciones)
            .setTitle("Selecciona color")
            .setItems(items) { dialog, which ->
                with(bindings.textViewLorem){
                    when(which){
                        0 -> {
                            setBackgroundColor(getColor(R.color.white))
                            setTextColor(getColor(R.color.black))
                        }
                        1 -> {
                            setBackgroundColor(getColor(R.color.black))
                            setTextColor(getColor(R.color.white))
                        }
                        2 -> {
                            setBackgroundColor(getColor(R.color.black))
                            setTextColor(getColor(R.color.green))
                        }
                    }
                }
                Log.i("Colores", "Opcion elegida: " + items[which])
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
    private fun showTamanyo(){
        val items = arrayOf("Pequeño", "Normal", "Grande")
        AlertDialog.Builder(this@Notificaciones)
            .setTitle("Selecciona tamaño")
            .setItems(items) { dialog, which ->
                with(bindings.textViewLorem){
                    when(which){
                        0 -> setTextSize(TypedValue.COMPLEX_UNIT_SP, 8f)
                        1 -> setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
                        2 -> setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                    }
                }
                Log.i("Tamaño", "Opcion elegida: " + items[which])
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
    // NOTIFICACIONES BARRA DE ESTADO
    private fun createNotificationChannel() { // antes de enviar notificacion
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // Crear el canal solo para API 26+
            val name = "Canal de tareas"
            val imp = NotificationManager.IMPORTANCE_HIGH // por si acaso no se muestra con la app abierta

            val channel = NotificationChannel(CHANNEL_ID, name, imp)
            channel.description = "Canal para el ejercicio de tareas"

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private fun getPendingIntent(): PendingIntent {
        val intent = Intent(this@Notificaciones, Notificaciones::class.java)
        return PendingIntent.getActivity(
            this@Notificaciones,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
    private fun pedirPermisoNotificaciones() {
        if (Build.VERSION.SDK_INT >= 33) {
            val permission = android.Manifest.permission.POST_NOTIFICATIONS
            if (ContextCompat.checkSelfPermission(this@Notificaciones, permission)
                != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                    this@Notificaciones,
                    arrayOf(permission),
                    REQUEST_PERMISSION_CODE
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun mostrarNotificacion() {

        val texto = "Tareas iniciadas: $contTareas"

        val builder = NotificationCompat.Builder(this@Notificaciones, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Gestión de tareas")
            .setContentText(texto)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentIntent(getPendingIntent())
            .setAutoCancel(false)

        val notificationManager = NotificationManagerCompat.from(this@Notificaciones)

        // Verificar permiso en Android 13+
        if (Build.VERSION.SDK_INT >= 33 &&
            !notificationManager.areNotificationsEnabled()) {
            Toast.makeText(this, "Permiso de notificaciones no concedido", Toast.LENGTH_SHORT).show()
            return
        }
        //builder.setContentText("Notificación modificada")
        notificationManager.notify(NOTIF_ID, builder.build())
    }
    private fun showIniciar(){
        contTareas++
        mostrarNotificacion()
    }
    private fun showDetener(){
        if (contTareas > 0) {
            contTareas--
            if (contTareas == 0) {
                val notificationManager = NotificationManagerCompat.from(this@Notificaciones)
                notificationManager.cancel(NOTIF_ID)
            } else {
                mostrarNotificacion()
            }
        }
    }
}