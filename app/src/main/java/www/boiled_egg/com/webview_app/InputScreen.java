package www.boiled_egg.com.webview_app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InputScreen extends Activity implements View.OnClickListener{

    Button button1,button2,button3;
    String url1 = "http://youtube.com";
    String url2 = "http://akosha.atlassian.net";
            // "https://m.akosha.atlassian.net/secure/CreateIssueDetails!init.jspa?pid=12100&issuetype=1&customfield_11308=example@gmail.com&description=Problem%20Faced:%20%0A%0A%0A%0ASteps%20To%20Reproduce:%20";
    String url3 = "http://amazon.in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


//        Toast.makeText(getApplicationContext(), "Reached Here", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_1:
                Toast.makeText(getApplicationContext(), "Button 1", Toast.LENGTH_SHORT).show();

                Intent i1 = new Intent(getApplicationContext(), WebViewActivity.class);
                i1.putExtra("url",url1);
                startActivity(i1);

                break;

            case R.id.button_2:
                Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();

                Intent i2 = new Intent(getApplicationContext(), WebViewActivity.class);
                i2.putExtra("url",url2);
                startActivity(i2);

                break;

            case R.id.button_3:
                Toast.makeText(getApplicationContext(), "Button 3", Toast.LENGTH_SHORT).show();

//                Intent i3 = new Intent(Intent.ACTION_SEND);
//                i3.setData(Uri.parse("mailto:"));
//                String[] to = {"sumitsarkar.iitk@gmail.com","feedback.helpchat@gmail.com"};
//                i3.putExtra(Intent.EXTRA_EMAIL,to);
//                i3.putExtra(Intent.EXTRA_SUBJECT,"hi, this was sent from my App");
//                i3.putExtra(Intent.EXTRA_TEXT, "hey whats up?");
//                i3.setType("message/rfc822"); // this is extremely important to specify the mime type o/w app may crash
//                startActivity(i3);

                try {
                    GMailSender sender = new GMailSender("noreply.helpchat@gmail.com", "helpchat123");
                    sender.sendMail("This is Subject",
                            "This is Body",
                            "feedback.helpchat@gmail.com",
                            "feedback.helpchat@gmail.com");
                    Log.d("Send Mail +ve","Sent");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                break;
        }
    }
}













// Extra Items

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }


//                if (TextUtils.isEmpty(currentUrl)) {
//                    currentUrl = url;
//                }
//                try {
//                    final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl));
//                    startActivity(intent);
//                } catch (Exception e) {
//
//                }