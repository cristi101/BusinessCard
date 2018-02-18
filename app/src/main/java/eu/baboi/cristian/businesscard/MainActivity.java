package eu.baboi.cristian.businesscard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the logo dimensions if in landscape

        // Get the display
        Display display = getWindowManager().getDefaultDisplay();

        // It is landscape?
        if(display.getRotation()!= Surface.ROTATION_0 ) {

            // Get the display metrics
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);

            // Find the logo
            final ImageView logo = (ImageView) findViewById(R.id.id_logo);

            // Set the logo dimensions
            logo.setMaxWidth(metrics.widthPixels-((int)(24*metrics.density)));
            logo.setMaxHeight(metrics.heightPixels-((int)(24*metrics.density)));
            Log.e("aaaaa",String.valueOf(metrics.density)+"\n"+String.valueOf(metrics.widthPixels)+"\n"+String.valueOf(metrics.heightPixels));

        }

        // Recognize the links in the address field

        // Find the address field
        final TextView addr = (TextView) findViewById(R.id.id_address);

        // https://discussions.udacity.com/t/how-to-put-links-in-a-textview/507450/2?u=cristian.baboi
        addr.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
