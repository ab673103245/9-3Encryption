package qianfeng.a9_3encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 接触安卓一些加密的工具类，base64,MD5
public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = ((TextView) findViewById(R.id.result));
    }

    public void base64Encode(View view) {

        byte[] bytes = Base64.encode("AB".getBytes(), Base64.DEFAULT);

        result.setText(new String(bytes,0,bytes.length));
    }

    public void base64Decode(View view) {
        byte[] bytes = Base64.decode(result.getText().toString(), Base64.DEFAULT);

        result.setText(new String(bytes,0,bytes.length));
    }

    public void md5(View view) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            byte[] bytes = digest.digest("HelloAndroid".getBytes());
            // 99%的情况，你直接用这个bytes来new一个String，显示的结果都是让人看不懂的字符串
            // 所以来个Base64工具类编码一下吧
            byte[] encode = Base64.encode(bytes, Base64.DEFAULT);

            result.setText(new String(encode,0,encode.length));
            

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
