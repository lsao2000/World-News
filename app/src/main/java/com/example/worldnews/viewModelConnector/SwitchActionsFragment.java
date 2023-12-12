
package com.example.worldnews.viewModelConnector;
/**
 * SwitchActionsFragment
 */
import android.content.Context;

import com.example.worldnews.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SwitchActionsFragment {

    public static void swithFragment(int id, Fragment fragment, FragmentManager support){

        FragmentTransaction fragmentTransaction = support.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}
