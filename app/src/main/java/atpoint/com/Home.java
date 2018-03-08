package atpoint.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener {
    private CardView bookingCard ,emergencyCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //bookingCard  = findViewById(R.id.bookingbtnId);
        emergencyCard  = findViewById(R.id.emergencybtnId);

       // bookingCard.setOnClickListener(this);
        emergencyCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch(view.getId()){
            //case R.id.bookingbtnId :
              //  i = new Intent(this , Booking.class);
               // startActivity(i);
               // break;
            case  R.id.emergencybtnId :
                i=new Intent(this , Emergency.class);
                startActivity(i);
                break;
            default:
                break;

        }

    }
}