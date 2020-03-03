package hr.unidu.kruno.promjenalayouta3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        // Započni transakciju
        FragmentTransaction ft = fm.beginTransaction();
        // Zamijeni sadržaj kontejnera aktivnosti drugim fragmentom
        ft.replace(R.id.drugi_fragment, new FragmentActivity2());
        //ft.addToBackStack("tag1");
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Potvrdi promjenu
        ft.commit();
    }

    @Override // SPREMANJE STANJA
    protected void onSaveInstanceState(final Bundle stanje) {
        super.onSaveInstanceState(stanje);
           // Sprema se stanje svih važnih varijabli
            CheckBox br = findViewById(R.id.checkRedovan);
            CheckBox up = findViewById(R.id.checkUpisan);
            RatingBar rb = findViewById(R.id.ratingBar);
            stanje.putBoolean("redovan", br.isChecked());
            stanje.putBoolean("upisan", up.isChecked());
            stanje.putFloat("brojZvjezdica", rb.getRating());
    }
    @Override // UČITAVANJE SPREMLJENOG STANJA
    protected void onRestoreInstanceState(final Bundle spremljenoStanje){
        super.onRestoreInstanceState(spremljenoStanje);
            // Sprema se stanje svih važnih varijabli
            CheckBox br = findViewById(R.id.checkRedovan);
            CheckBox up = findViewById(R.id.checkUpisan);
            RatingBar rb = findViewById(R.id.ratingBar);
            br.setChecked(spremljenoStanje.getBoolean("redovan"));
            up.setChecked(spremljenoStanje.getBoolean("upisan"));
            rb.setRating(spremljenoStanje.getFloat("brojZvjezdica"));
    }

}
