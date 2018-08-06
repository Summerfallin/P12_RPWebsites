package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class website extends AppCompatActivity {

    WebView wvPage;
    TextView tvPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);
        wvPage=findViewById(R.id.webViewPage);
        tvPage=findViewById(R.id.textView3);


        Intent intentReceived=getIntent();
        String value = intentReceived.getStringExtra("url");
        tvPage.setText(value);

        wvPage.setWebViewClient(new WebViewClient());


//        WebSettings webSettings = wvPage.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);
        wvPage.loadUrl(value);



    }
}
