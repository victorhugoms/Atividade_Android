package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Objetos encapsulados
    private EditText editTextNota1;
    private EditText editTextNota2;
    private EditText editTextNota3;
    private TextView textViewmedia;
    private TextView textViewMaior;
    private TextView textViewMenor;
    private TextView textViewvisualMedio;
    private TextView textViewvisualMenor;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNota1 = findViewById(R.id.edit_Text_n1);
        editTextNota2 = findViewById(R.id.edit_Text_n2);
        editTextNota3 = findViewById(R.id.edit_Text_n3);
        textViewMaior = findViewById(R.id.text_View_Maior);
        textViewmedia = findViewById(R.id.text_View_media);
        textViewMenor = findViewById(R.id.text_View_menor);
        textViewvisualMedio = findViewById(R.id.text_View_visual_media);
        textViewvisualMenor = findViewById(R.id.text_View_visual_menor);
        imageView = findViewById(R.id.image_view_resultado);

        imageView.setVisibility(View.INVISIBLE);


    }


    public void calcularmedia(View v) {
        Integer nota1 = Integer.parseInt(editTextNota1.getText()
                .toString());
        Integer nota2 = Integer.parseInt(editTextNota2.getText()
                .toString());
        Integer nota3 = Integer.parseInt(editTextNota3.getText()
                .toString());

        Integer media = (nota1 + nota2 + nota3) / 3;

        textViewmedia.setText(media.toString());

        if (nota1 >= nota2 && nota1 >= nota3) {
            textViewMaior.setText(nota1.toString());
        } else if (nota2 >= nota1 && nota2 >= nota3) {
            textViewMaior.setText(nota2.toString());
        } else if (nota3 >= nota1 && nota3 >= nota2) {
            textViewMaior.setText(nota3.toString());
        }

        if (nota1 <= nota2 && nota1 <= nota3) {
            textViewMenor.setText(nota1.toString());
        } else if (nota2 <= nota1 && nota2 <= nota3) {
            textViewMenor.setText(nota2.toString());
        } else if (nota3 <= nota1 && nota3 <= nota2) {
            textViewMenor.setText(nota3.toString());
        }
        if (media < 5) {
            textViewmedia.setTextColor(getResources()
                    .getColor(R.color.baixa));
            textViewvisualMedio.setTextColor(getResources()
                    .getColor(R.color.baixa));
            imageView.setImageResource(R.drawable.reprovado);
            imageView.setVisibility(View.VISIBLE);

        } else if (media > 5) {
            textViewmedia.setTextColor(getResources()
                    .getColor(R.color.alta));
            textViewvisualMedio.setTextColor(getResources()
                    .getColor(R.color.alta));
            imageView.setImageResource(R.drawable.aprovado);
            imageView.setVisibility(View.VISIBLE);
        }

    }
}
