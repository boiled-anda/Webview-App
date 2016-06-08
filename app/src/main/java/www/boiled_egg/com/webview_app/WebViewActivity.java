package www.boiled_egg.com.webview_app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.*;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_screen);

        // Getting Data from Input Screen
        Intent i = getIntent();
        String url = i.getStringExtra("url");
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();

        mWebView = (WebView) findViewById(R.id.webview_portion);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Use remote resource
        mWebView.loadUrl(url);

        // Stop local links and redirection from opening in browser instead of WebView
        mWebView.setWebViewClient(new MyAppWebViewClient());

        // Use local resource
        // mWebView.loadUrl("???");

    }

/*
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()){
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

}



// Extra Resources:

// Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();