package androidhive.info.materialdesign.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class RenexBoldCustomTextView extends TextView {

	public RenexBoldCustomTextView(Context context) {
		super(context);
	}

	public RenexBoldCustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (!isInEditMode()) {
			createTypeface(context, attrs); //whatever added functionality you are trying to add to Widget, call that inside this condition. 
		}

	}

	public RenexBoldCustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}


	//Typeface I wan to set to my Custom TextView It can be any other functionality of your choice
	private void createTypeface(Context context, AttributeSet attrs) {

		Typeface typeface = Typeface.createFromAsset(context.getAssets(),"font/renemedium.otf");

		setTypeface(typeface);
	}
}
