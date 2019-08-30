package sideproj.anshul.shammo.com.massmessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] number = {"8807572166","8525921980","7709194080","9487446179","8110072409","9884013981","9698584050","9629035241","9943647577","9944928681","9791424485","7339582223","8056961706","8110848568","9444126578","9597814226","9597714856","9994034196","8760134502","8056937524","8438988516","9952990590","8220857057","8190959215","8438136567","9751590777","9751667357","9411848949","9791755728","8273564628","9443743638","9597800440","7373524565","8220389884","8979900989","9944599603","7538874229","7248884206","9445875602","8903671867","9791363918","9791756188","9629356026","8526569331","7064050228","9488991750","8220065522","7502179221","8144366985","8754960603","7708705400","9840029427","8012052627","9578312704","9410285540","8248704838","9003992520","8667422017","9443571076","8973381936","8300680605","9486937141","9750361683","8220452003","7248537241","9578514860","7092309961","9442710723","7373437821","9994767002","8428326448","8870200129","9500154162","9566646069","9095091601","8883566195","9719841000","7601011106","7373181473","9600209042","9976380639","9524094534","9543205514","9942955474","8129071450","8940967620","8220660345","8015006994","8489297652","7981709164","9962314618","8807972837","8870903232","7500460592","8807951012","7500722579","9629104848","9487204456","7010235819","9884431328"};
                String Message = "Stumagz presents 'The Engineering Scholarship Exam' a Free Online Exam for engineering students.\n" +
                        "Prizes worth INR 20,000\n" +
                        "Register now at http://bit.do/tese2019";
                for(int i=0;i<100;i++) {
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(number[i],null,Message,null,null);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(MainActivity.this,"DONE",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case 1: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(MainActivity.this,"Permission granted",Toast.LENGTH_SHORT).show();
                    }
                }
                return;
            }
        }

    }


}
