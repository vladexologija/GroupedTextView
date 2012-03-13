package test.test;

import com.vladexologija.widget.GroupedTextView;
import android.app.Activity;
import android.os.Bundle;

public class GroupedViewTextActivity extends Activity {
	
	private GroupedTextView groupedView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        groupedView = (GroupedTextView) findViewById(R.id.grouped_view);
        groupedView.addPlainTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        
        groupedView = (GroupedTextView) findViewById(R.id.grouped_view1);
        groupedView.addPlainTextView("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        groupedView.addPlainTextView("Cras non tellus vel magna dapibus malesuada.");
        groupedView.addPlainTextView("Phasellus pulvinar, est in sagittis porttitor, ligula metus pretium dui.");
        
        groupedView = (GroupedTextView) findViewById(R.id.grouped_view2);
        groupedView.addEditTextView("Username","Username");
        groupedView.addEditTextView("Password","Passwrod");

    }
}