package somdosbichos.cursoandroid.com.somdosbichos;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

//implementa uma interface para não precisar criar  várias OnClickView
public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        cao = findViewById(R.id.caoId);
        gato = findViewById(R.id.gatoId);
        leao = findViewById(R.id.leaoId);
        macaco = findViewById(R.id.macacoId);
        ovelha = findViewById(R.id.ovelhaId);
        vaca = findViewById(R.id.vacaId);


        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);


    }
//caso a Id capturada no contexto MainActivity seja igual a id dos animais, vai tocar o som.
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.caoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                tocarSom();
                break;

            case R.id.gatoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                tocarSom();
                break;

            case R.id.leaoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                tocarSom();
                break;

            case R.id.macacoId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                tocarSom();
                break;

            case R.id.vacaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                tocarSom();
                break;

            case R.id.ovelhaId:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                tocarSom();
                break;

        }


    }



    public void tocarSom() {

        if (mediaPlayer != null) {
            mediaPlayer.start();


//            Ao terminar de executar o som ele sai da memória
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });

        }

    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;


        }
        super.onDestroy();
    }
}