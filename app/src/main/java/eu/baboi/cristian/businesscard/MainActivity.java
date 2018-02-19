package eu.baboi.cristian.businesscard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adjust the logo size for landscape orientation
        fixLandscape();

        // Recognize the links in the address field
        exposeLinks();
    }


    // This method expose the links in the address field
    private void exposeLinks() {
        // Find the address field
        final TextView addr = (TextView) findViewById(R.id.id_address);

        // See https://discussions.udacity.com/t/how-to-put-links-in-a-textview/507450/2?u=cristian.baboi
        // Mark the links in the address field
        addr.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // This method sets the limits for the logo size to the screen size
    private void fixLandscape() {

        // Get the display metrics
        final DisplayMetrics metrics = new DisplayMetrics();
        getMetrics(metrics);

        // Put bounds to the logo size if we are in landscape orientation
        if (isLandscape(metrics)) {

            // Find the logo
            final ImageView logo = (ImageView) findViewById(R.id.id_logo);

            // Set the logo bounds
            logo.setMaxWidth(metrics.widthPixels); // not necessary
            // Set the maxHeight bound to screen height adjusted with the status bar size: 24dp
            logo.setMaxHeight(metrics.heightPixels - ((int) (24 * metrics.density)));
        }
    }

    /**
     * This is an utility method for getting the screen metrics
     *
     * @param metrics the DisplayMetrics to get
     */
    void getMetrics(DisplayMetrics metrics) {

        // See https://developer.android.com/reference/android/util/DisplayMetrics.html

        // Get the display
        final Display display = getWindowManager().getDefaultDisplay();

        // Get the metrics
        display.getMetrics(metrics);
    }

    /**
     * This is an utility method for detecting the metrics orientation
     *
     * @param metrics The screen metrics to check
     * @return true if metrics are for Landscape orientation, false if not
     */
    boolean isLandscape(DisplayMetrics metrics) {
        return (metrics.widthPixels > metrics.heightPixels);
    }

}
