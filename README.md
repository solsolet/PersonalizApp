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
```xml
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
```xml
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
He creado las imágenes con GIMP con los colores correspondientes y las he añadido al proyecto en la carpeta de drawables. Para usarlas en el botón he creado `boton_imagen` de la siguiente manera: 
```xml
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- presionado : gris oscuro -->
    <item android:state_pressed="true"
        android:drawable="@drawable/boton_pressed" />
    <!-- seleccionado : amarillo -->
    <item android:state_focused="true"
        android:drawable="@drawable/boton_focused" />
    <!-- normal: no seleccionado ni presionado : gris claro -->
    <item android:drawable="@drawable/boton_normal" />
</selector>
```
Este código se ha usado para el botón `buttonPersonalizado` como fondo: `android:background="@drawable/boton_imagen"`. El resultado ha sido que al ejecutar la aplicación, el botón por defecto está gris oscuro, si lo pulsamos gris claro y si le damos el foco (con _tab_) amarillo.
![Seleccionable botón](img-readme/Drawables_Ej2-Boton.gif)
Las esquinas por suerte no se ven estiradas, pero por si acaso he implementado la versión con 9-patches ![9 patches](img-readme/boton-9patches.png).

#### Ejercicio 3. Animación por fotogramas
Para animar he añadido un elemento `ProgressBar` al cual en su atributo `indterminateDrawable` le he puesto `animacion` que es una `animation-list`. Esta lista animada se repite en bucle gracia al atributo `oneshot="false"`.
```xml
<ProgressBar
    android:id="@+id/progressBar"
    style="?android:attr/progressBarStyle"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="52dp"
    android:indeterminateDrawable="@drawable/animacion"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintHorizontal_bias="0.5"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/buttonPersonalizado" />
```
```xml
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">
    <item android:drawable="@drawable/animacion1" android:duration="1000"/>
    <item android:drawable="@drawable/animacion2" android:duration="1000"/>
    <item android:drawable="@drawable/animacion3" android:duration="1000"/>
    <item android:drawable="@drawable/animacion4" android:duration="1000"/>
    <item android:drawable="@drawable/animacion5" android:duration="1000"/>
</animation-list>
```
#### Ejercicio 4. Niveles
Para los niveles he añadido una _SeekBar_ en `drawables.xml`. Se cambia el drawable que se muestra al cambiar la barra de valor con el atributo `progressDrawable` que usa el archivo `nivel_color.xml` para determinar a que rectángulo de color usar según el rango.
```xml
<SeekBar
    android:id="@+id/seekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="64dp"
    android:max="10000"
    android:progressDrawable="@drawable/nivel_color"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/progressBar" />
```
He añadido nuevos colores en `values/colors.xml` para poder usar-los al crear os cuadrados de colores. Los cuadrados tienen de nombre "rs_[color]". 
```xml
<?xml version="1.0" encoding="utf-8"?>
<level-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:minLevel="0" android:maxLevel="2500" android:drawable="@drawable/rs_green"/>
    <item android:minLevel="2501" android:maxLevel="5000" android:drawable="@drawable/rs_yellow"/>
    <item android:minLevel="5001" android:maxLevel="7500" android:drawable="@drawable/rs_orange"/>
    <item android:minLevel="7501" android:maxLevel="10000" android:drawable="@drawable/rs_red"/>
</level-list>
```
### Pe
## Sesión 10
