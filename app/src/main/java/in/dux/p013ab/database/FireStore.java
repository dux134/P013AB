package in.dux.p013ab.database;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

import in.dux.p013ab.websites.WebsiteDataModel;

import static android.content.ContentValues.TAG;

/**
 * Created by root on 5/28/18.
 */

public class FireStore {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String string;
    private StorageReference storage = FirebaseStorage.getInstance().getReference();

    public ArrayList<WebsiteDataModel> loadWebsiteList() {
        final ArrayList<WebsiteDataModel> list = new ArrayList<>();
        list.clear();

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);

        db.collection("websites").orderBy("location", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot querySnapshot,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w(TAG, "Listen error", e);
                            return;
                        }

                        assert querySnapshot != null;
                        for (DocumentChange change : querySnapshot.getDocumentChanges()) {
                            if (change.getType() == DocumentChange.Type.ADDED) {
//                                String rollNumber = change.getDocument().get("roll_no").toString();
                                String name = change.getDocument().get("name").toString();
                                String websiteUrl = change.getDocument().get("websiteUrl").toString();
                                String imageUrl = change.getDocument().get("fileUrl").toString();

                                list.add(new WebsiteDataModel(name,websiteUrl,imageUrl));
                            }

                            String source = querySnapshot.getMetadata().isFromCache() ?
                                    "local cache" : "server";
                            Log.d(TAG, "Data fetched from " + source);
                        }
                    }
                });
        return list;
    }
}
