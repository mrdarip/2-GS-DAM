package com.exampi.ej1examen

enum class Dado(val valor: Int?, val drawable: Int) {
    LOGO(null, R.drawable.logo_dados),
    UNO(1,R.drawable.dado1),
    DOS(2, R.drawable.dado2),
    TRES(3, R.drawable.dado3),
    CUATRO(4, R.drawable.dado4),
    CINCO(5, R.drawable.dado5),
    SEIS(6, R.drawable.dado6)
}

/*
<TextView
android:id="@+id/txtPreguntaTipoPiza"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginStart="16dp"
android:layout_marginTop="16dp"
android:text="@string/pregunta_tipo_pizza"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toTopOf="parent" />

<androidx.constraintlayout.widget.Guideline
android:id="@+id/guideline"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="vertical"
app:layout_constraintGuide_begin="71dp" />

<androidx.constraintlayout.widget.Guideline
android:id="@+id/guideline2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:orientation="vertical"
app:layout_constraintGuide_begin="16dp" />

<androidx.constraintlayout.widget.Barrier
android:id="@+id/barrera1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
app:barrierDirection="bottom"
app:constraint_referenced_ids="grupoBotones" />

<RadioGroup
android:id="@+id/grupoBotones"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginTop="16dp"
app:layout_constraintStart_toStartOf="@+id/guideline"
app:layout_constraintTop_toBottomOf="@+id/txtPreguntaTipoPiza">

<RadioButton
android:id="@+id/radioButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/optPizza1" />

<RadioButton
android:id="@+id/radioButton2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/optPizza2" />

<RadioButton
android:id="@+id/radioButton3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/optPizza3" />

<RadioButton
android:id="@+id/radioButton4"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/optPizza4" />

<RadioButton
android:id="@+id/radioButton5"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="@string/optPizza5" />
</RadioGroup>

<TextView
android:id="@+id/textView2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_marginStart="16dp"
android:text="@string/pregunta_extras"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@id/barrera1" />

<TextView
android:id="@+id/textView3"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/pregunta_bebida"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@id/barrera2" />

<androidx.constraintlayout.widget.Barrier
android:id="@+id/barrera2"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
app:barrierDirection="bottom"
app:constraint_referenced_ids="chipExtra2,chipExtra4,chipExtra1,chipExtra3" />

<com.google.android.material.chip.Chip
android:id="@+id/chipExtra2"
style="@style/Widget.MaterialComponents.Chip.Choice"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/extra4"
app:layout_constraintEnd_toStartOf="@+id/chipExtra1"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/textView2" />

<com.google.android.material.chip.Chip
android:id="@+id/chipExtra4"
style="@style/Widget.MaterialComponents.Chip.Choice"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/extra2"
app:layout_constraintBottom_toBottomOf="@+id/chipExtra1"
app:layout_constraintEnd_toStartOf="@+id/chipExtra3"
app:layout_constraintStart_toEndOf="@+id/chipExtra1"
app:layout_constraintTop_toTopOf="@+id/chipExtra1" />

<com.google.android.material.chip.Chip
android:id="@+id/chipExtra1"
style="@style/Widget.MaterialComponents.Chip.Choice"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/extra3"
app:layout_constraintBottom_toBottomOf="@+id/chipExtra2"
app:layout_constraintEnd_toStartOf="@+id/chipExtra4"
app:layout_constraintStart_toEndOf="@+id/chipExtra2"
app:layout_constraintTop_toTopOf="@+id/chipExtra2" />

<com.google.android.material.chip.Chip
android:id="@+id/chipExtra3"
style="@style/Widget.MaterialComponents.Chip.Choice"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="@string/extra1"
app:layout_constraintBottom_toBottomOf="@+id/chipExtra4"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toEndOf="@+id/chipExtra4"
app:layout_constraintTop_toTopOf="@+id/chipExtra4" />

<ImageView
android:id="@+id/imageView"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida1"
tools:src="@tools:sample/avatars" />

<ImageView
android:id="@+id/imageView2"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida2"
tools:src="@tools:sample/avatars" />

<ImageView
android:id="@+id/imageView3"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida3"
tools:src="@tools:sample/avatars" />

<ImageView
android:id="@+id/imageView4"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida4"
tools:src="@tools:sample/avatars" />

<ImageView
android:id="@+id/imageView5"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida5"
tools:src="@tools:sample/avatars" />

<ImageView
android:id="@+id/imageView6"
android:layout_width="90dp"
android:layout_height="90dp"
android:scaleType="fitXY"
app:srcCompat="@drawable/bebida6"
tools:layout_editor_absoluteX="182dp"
tools:layout_editor_absoluteY="312dp"
tools:src="@tools:sample/avatars" />

<androidx.constraintlayout.helper.widget.Flow
android:id="@+id/flow"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
app:constraint_referenced_ids="imageView,imageView2,imageView3,imageView4,imageView5,imageView6"
app:flow_horizontalGap="8dp"
app:flow_horizontalStyle="spread"
app:flow_wrapMode="chain"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/textView3" />

<EditText
android:id="@+id/editTextTextMultiLine"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:layout_marginTop="20dp"
android:ems="10"
android:gravity="start|top"
android:hint="Introduce tu dirección"
android:inputType="textMultiLine"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@+id/flow" />

<EditText
android:id="@+id/editTextText"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:ems="10"
android:hint="Introduce tu nombre"
android:inputType="text"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@+id/editTextTextMultiLine" />

<EditText
android:id="@+id/editTextPhone"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:ems="10"
android:hint="Telefono"
android:inputType="phone"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@+id/editTextText" />

<CheckBox
android:id="@+id/checkBox"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:text="He leído los términos y acepto"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="@+id/guideline2"
app:layout_constraintTop_toBottomOf="@+id/editTextPhone" />
*/