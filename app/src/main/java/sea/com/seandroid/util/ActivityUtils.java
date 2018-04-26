package sea.com.seandroid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Helps Activities load their UI.
 */
public class ActivityUtils {

    public static void setFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId,
                                             boolean addToStack) {

        if (fragmentManager == null || fragment == null) {
            throw new NullPointerException("Fragment null in " + ActivityUtils.class);
        }
        FragmentTransaction t = fragmentManager.beginTransaction();
        t.add(frameId, fragment);
        t.commit();

        if (addToStack) {
            t.addToBackStack(null); // Allows return to the last View onBackPressed
        }
    }

    public static boolean hasNetwork(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
