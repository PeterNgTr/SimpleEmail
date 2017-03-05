package com.example.thanhnguyen.simpleemail.Models;

import android.content.Context;

import com.example.thanhnguyen.simpleemail.Constants.Constants;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;

import java.util.Arrays;

/**
 * Created by thanhnguyen on 3/5/17.
 */
public class GMailModel {

    public static GoogleAccountCredential GACred(Context context) {
        return GoogleAccountCredential.usingOAuth2(
                context, Arrays.asList(Constants.SCOPES))
                .setBackOff(new ExponentialBackOff());
    }

}

