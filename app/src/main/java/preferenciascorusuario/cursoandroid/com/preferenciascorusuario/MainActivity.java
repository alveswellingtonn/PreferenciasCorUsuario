package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private Button botaoSalvar;
    private RadioButton radioButtonSelecionado;
    private ConstraintLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "arqPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupId);
        botaoSalvar = findViewById(R.id.botaoSalvarId);
        layout = findViewById (R.id.layoutId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int idradioGroupEscolhido = radioGroup.getCheckedRadioButtonId();

                if(idradioGroupEscolhido>0) {

                    radioButtonSelecionado = findViewById(idradioGroupEscolhido);

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();
                    String corEscolhida =  radioButtonSelecionado.getText().toString();
                    editor.putString("Cor Escolhida ",corEscolhida);
                    editor.commit();

                    setbackground (corEscolhida);
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setbackground(corRecuperada);
        }
    }

    private void setbackground( String cor) {

        if (cor.equals("Azul")) {
            layout.setBackgroundColor(Color.parseColor("#FF091788"));
        } else if (cor.equals("Vermelho")) {
            layout.setBackgroundColor(Color.parseColor("#FFBA0808"));
        } else if (cor.equals("Laranja")) {
            layout.setBackgroundColor(Color.parseColor("#FFF77F23"));
        }
    }
}
