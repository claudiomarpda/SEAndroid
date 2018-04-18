package sea.com.seandroid.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Helps Activities load their UI.
 */
public class ActivityUtils {

        public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                                  @NonNull Fragment fragment, int frameId) {

            if(fragmentManager == null || fragment == null) {
                throw new NullPointerException("Fragment null in " + ActivityUtils.class);
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }

}
