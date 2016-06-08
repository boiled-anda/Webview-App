package www.boiled_egg.com.webview_app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ctpl-01298 on 5/28/16.
 */
public class MyAppWebViewClient extends WebViewClient {


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if ((Uri.parse(url).getHost().endsWith("youtube.com"))||(Uri.parse(url).getHost().endsWith("amazon.in"))||(Uri.parse(url).getHost().endsWith("akosha.atlassian.net"))) {
            return false;
        }

        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
