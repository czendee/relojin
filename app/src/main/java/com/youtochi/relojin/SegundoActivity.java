package com.youtochi.relojin;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SegundoActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mClockView = (TextView) findViewById(R.id.clock);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }

    /** Called when the user clicks the Cerrar */
    public void irCerrar(View view) {
        finish();
    }

    /** Called when the user clicks the Guarda */
    public void irGuardaWeb(View view) {




        System.out.println("goToAdd Comando RIGHT Robot - 2");
        //old asp api /accessDB                   RequestTaskAddNuevaRutinaWeb th=new RequestTaskAddNuevaRutinaWeb();
// new nodejs api/mongodb
//        RequestTaskEnviarComandoRobotWeb th=new RequestTaskEnviarComandoRobotWeb();
        RequestTaskAddNuevaRutinaWeb th=new RequestTaskAddNuevaRutinaWeb();

        System.out.println("goToAdd Comando RIGHT Robot - 3");
//not used when added a comand,but used when updating a comand status        th.id="5a98754b8ab7e30004e75fee";
        th.nombreRutina="bolastino";
//                    th.nombreRutina= nombreRutinario.getText().toString();
        th.secuencia="24";

//                    th.secuencia=listasecuencia;
        System.out.println("goToAdd Comando RIGHT Robot - 4");
        th.comando="RIGTH";
//                    th.comando=listacomandos;
        System.out.println("goToAdd Comando RIGHT Robot - 5");
        th.tiempo="2344";

        th.status="reloj";
//                    th.tiempo=listatiempos;

        //                    TextView txtText = (TextView) findViewById(R.id.textResult);
        TextView txtText=null;
        th.execute(txtText); // here the result in text will be displayed
        System.out.println("goToAdd RIGHT ComandoRobot - 4");

//        finish();
        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                ConfirmationActivity.SUCCESS_ANIMATION);
        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,
                getString(R.string.confirmacionMsg));
        startActivity(intent);
    }


}
