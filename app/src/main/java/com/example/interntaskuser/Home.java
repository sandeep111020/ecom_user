package com.example.interntaskuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    ImageView imageView;
    TextView name,desc,price,gst,offer;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("Images").child("imageURL");
    private DatabaseReference first1 = databaseReference.child("Images").child("imageCatg");
    private DatabaseReference first2 = databaseReference.child("Images").child("imageName");
    private DatabaseReference first3 = databaseReference.child("Images").child("imagePrice");
    private DatabaseReference first4 = databaseReference.child("Images").child("imageGst");
    private DatabaseReference first5 = databaseReference.child("Images").child("imageOffer");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageView = findViewById(R.id.imageview);
        name=findViewById(R.id.productname);
        desc=findViewById(R.id.productdesc);
        price=findViewById(R.id.productprice);
        gst=findViewById(R.id.withgst);
        offer=findViewById(R.id.offer);




       /* ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Findianexpress.com%2Farticle%2Fparenting%2Ffamily%2Freasons-kids-should-be-given-limited-toys-play-5985785%2F&psig=AOvVaw0U44sctEgFO_TLass06P9X&ust=1618655210306000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJD96uXGgvACFQAAAAAdAAAAABAD","1 image"));
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Findianexpress.com%2Farticle%2Fparenting%2Ffamily%2Freasons-kids-should-be-given-limited-toys-play-5985785%2F&psig=AOvVaw0U44sctEgFO_TLass06P9X&ust=1618655210306000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJD96uXGgvACFQAAAAAdAAAAABAD","1 image"));
        slideModels.add(new SlideModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Findianexpress.com%2Farticle%2Fparenting%2Ffamily%2Freasons-kids-should-be-given-limited-toys-play-5985785%2F&psig=AOvVaw0U44sctEgFO_TLass06P9X&ust=1618655210306000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJD96uXGgvACFQAAAAAdAAAAABAD","1 image"));
        imageSlider.setImageList(slideModels,true);*/


    }

    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        first1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                desc.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        first2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        first3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                price.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        first4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                gst.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        first5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                offer.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}