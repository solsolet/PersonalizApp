# Android Avanzado
Para esta práctica he creado una única aplicación llamada _PersonalizApp_. La pantalla principal nos permitirá ver que práctica queremos visualizar según el botón que pulsemos. En caso de tener algún problema visualizando la práctica se puede consultar en [GitHub](https://github.com/solsolet/PersonalizApp.git).
## Sesión 8
### Drawables
Accedemos al pulsar el primer botón `Drawables`.
#### Ejercicio 1. Personalización del aspecto
<!-- Explicació activitat -->
Para hacer este ejercicio he creado los ficheros:
+ `Drawables.kt`: clase donde irá todo el código de la aplicación. No tiene nada puesto todavía.
+ `drawables.xml`: layout para la clase `Drawables`. Tiene el elemento _TextView_ que se pide.
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textViewDrawable"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/fondo"
        android:gravity="center"
        android:text="@string/drawable"
        android:textColor="@color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.5" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
+ `fondo.xml`: elemento drawable dentro de la carpeta `res/drawable`. Tiene las etiquetas para darle aspecto al _drawable_.
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <stroke android:color="@color/blue" android:width="5dp"/>
    <corners android:radius="5dp"/>
    <gradient
        android:type="linear"
        android:startColor="@color/light_grey"
        android:endColor="@color/white" />
    <padding
        android:left="5dp"
        android:top="5dp"
        android:right="5dp"
        android:bottom="5dp" />
</shape>
```
+ `colors.xml`: este no lo he creado yo, pero lo he aprovechado para definir los colores que voy a usar. De momento solo he definido `blue` y `light_grey`.
<!-- Respostes a preguntes-->
El margen se puede definir dentro de la definición de _drawable_ con la etiqueta `<padding>`. Des del layout también sería posible con `android:padding`.

#### Ejercicio 2. Personalización de los botones
He creado las imágenes con GIMP.
#### Ejercicio 3. Animación por fotogramas
#### Ejercicio 4. Niveles
## Sesión 10