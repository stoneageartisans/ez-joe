package com.stoneageartisans.ezjoe;

import java.util.Properties;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class EZJoe extends Activity {
	
	// Constants
	private final int FONT_SIZE = 20;
	private final int MALE = 0;
	private final int FEMALE = 1;
	private final int AGE_17to21 = 0;
	private final int AGE_22to26 = 1;
	private final int AGE_27to31 = 2;
	private final int AGE_32to36 = 3;
	private final int AGE_37to41 = 4;
	private final int AGE_42to46 = 5;
	private final int AGE_47to51 = 6;
	private final int AGE_52to56 = 7;
	private final int AGE_57to61 = 8;
	private final int AGE_62andup = 9;
	private final int AGE_17to20 = 0;
	private final int AGE_21to27 = 1;
	private final int AGE_28to39 = 2;
	private final int AGE_40plus = 3;
	private final int RUN = 0;
	private final int SWIM = 1;
	private final int BICYCLE = 2;
	private final int WALK = 3;
	private final int NOGO = 0;
	private final int GO = 1;
		
	// Variables
	private ArrayAdapter<String> adapter_gender;
	private ArrayAdapter<String> adapter_age_apft;
	private ArrayAdapter<String> adapter_age_weight;
	private ArrayAdapter<String> adapter_event_aerobic;
	private Button button_apft;
	private Button button_heightweight;
	private Button button_bodyfat;
	private Button button_exit;
	private Button button_back;
	private Button button_recalculate;
	private EditText edittext_pushups;
	private EditText edittext_situps;
	private EditText edittext_minutes;
	private EditText edittext_seconds;
	private EditText edittext_score;
	private EditText edittext_height;
	private EditText edittext_minimum;
	private EditText edittext_maximum;
	private EditText edittext_neck;
	private EditText edittext_waist;
	private EditText edittext_hips;
	private EditText edittext_percentage;
	private int age;
	private int gender;
	private int event;
	private int alternate;
	private int screen_current;
	private int screen_main;
	private int screen_apft;
	private int screen_weight;
	private int screen_bodyfat;
	private Properties maximum_weight;
	private Properties minimum_weight;
	private Spinner spinner_gender;
	private Spinner spinner_age;
	private Spinner spinner_aerobic;
	private TextView textview_alternate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		initialize();
		show_main_menu();
	}
	
	@Override
	public void onBackPressed() {
		
		if(screen_current == R.layout.layout_main) {		
			super.onBackPressed();
		} else {			
			show_main_menu();			
		}
		
	}
	
	@Override
	public void onResume() {
		
	    super.onResume();
	    
	}
	
	@Override
	public void onPause() {
		
	    super.onPause();
	    
	}
	
	private void initialize() {
		
		// Assign values
		screen_main = R.layout.layout_main;
		screen_apft = R.layout.layout_apft;
		screen_weight = R.layout.layout_weight;
		screen_bodyfat = R.layout.layout_bodyfat;
		
		gender = MALE;
		age = AGE_17to21;
		event = RUN;
		alternate = NOGO;
		
		maximum_weight = new Properties();
		
		minimum_weight = new Properties();
		minimum_weight.setProperty("58", "91");
		minimum_weight.setProperty("59", "94");
		minimum_weight.setProperty("60", "97");
		minimum_weight.setProperty("61", "100");
		minimum_weight.setProperty("62", "104");
		minimum_weight.setProperty("63", "107");
		minimum_weight.setProperty("64", "110");
		minimum_weight.setProperty("65", "114");
		minimum_weight.setProperty("66", "117");
		minimum_weight.setProperty("67", "121");
		minimum_weight.setProperty("68", "125");
		minimum_weight.setProperty("69", "128");
		minimum_weight.setProperty("70", "132");
		minimum_weight.setProperty("71", "136");
		minimum_weight.setProperty("72", "140");
		minimum_weight.setProperty("73", "144");
		minimum_weight.setProperty("74", "148");
		minimum_weight.setProperty("75", "152");
		minimum_weight.setProperty("76", "156");
		minimum_weight.setProperty("77", "160");
		minimum_weight.setProperty("78", "164");
		minimum_weight.setProperty("79", "168");
		minimum_weight.setProperty("80", "173");
		minimum_weight.setProperty("81", "178");
		minimum_weight.setProperty("82", "183");
		minimum_weight.setProperty("83", "188");
		minimum_weight.setProperty("84", "193");
        
        // Set up array adapters
  		adapter_gender = new ArrayAdapter<String>(
  				this,
  				android.R.layout.simple_spinner_item,
  				this.getResources().getStringArray(R.array.gender) ) {
  			public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ( (TextView) view ).setTextSize(FONT_SIZE);
                return view;
    		}
    		public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
               ( (TextView) view ).setTextSize(FONT_SIZE);
               return view;
    		}
  		};
  		adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  		
  		adapter_age_apft = new ArrayAdapter<String>(
  				this,
  				android.R.layout.simple_spinner_item,
  				this.getResources().getStringArray(R.array.age_apft) ) {
  			public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ( (TextView) view ).setTextSize(FONT_SIZE);
                return view;
    		}
    		public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
               ( (TextView) view ).setTextSize(FONT_SIZE);
               return view;
    		}
  		};
  		adapter_age_apft.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  		
  		adapter_age_weight = new ArrayAdapter<String>(
  				this,
  				android.R.layout.simple_spinner_item,
  				this.getResources().getStringArray(R.array.age_weight) ) {
  			public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ( (TextView) view ).setTextSize(FONT_SIZE);
                return view;
    		}
    		public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
               ( (TextView) view ).setTextSize(FONT_SIZE);
               return view;
    		}
  		};
  		adapter_age_weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
  		
  		adapter_event_aerobic = new ArrayAdapter<String>(
  				this,
  				android.R.layout.simple_spinner_item,
  				this.getResources().getStringArray(R.array.event_aerobic) ) {
  			public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ( (TextView) view ).setTextSize(FONT_SIZE);
                ( (TextView) view ).setGravity(Gravity.RIGHT);
                return view;
    		}
    		public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
               ( (TextView) view ).setTextSize(FONT_SIZE);
               return view;
    		}
  		};
  		adapter_event_aerobic.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    
	}
	
	private void show_main_menu() {
		
		this.setContentView(screen_main);
		screen_current = screen_main;
		
		// Set title font sizes
        ( (TextView) this.findViewById(R.id.title_menu) ).setTextSize(FONT_SIZE);
        ( (TextView) this.findViewById(R.id.menu_spacer) ).setTextSize(FONT_SIZE);
        
        // Set up buttons        
        button_apft = (Button) this.findViewById(R.id.button_apft);
        button_apft.setTextSize(FONT_SIZE);
        button_apft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_apft_calculator();
			}        	
        });
        
        button_heightweight = (Button) this.findViewById(R.id.button_weight);
        button_heightweight.setTextSize(FONT_SIZE);
        button_heightweight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_weight_limits();
			}        	
        });
        
        button_bodyfat = (Button) this.findViewById(R.id.button_bodyfat);
        button_bodyfat.setTextSize(FONT_SIZE);
        button_bodyfat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_bodyfat_calculator();
			}        	
        });
        
        button_exit = (Button) this.findViewById(R.id.button_exit);
        button_exit.setTextSize(FONT_SIZE);
        button_exit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				exit_app();
			}        	
        });
		
	}
	
	private void show_apft_calculator() {
		
		this.setContentView(screen_apft);
		screen_current = screen_apft;
		
		// Set title font size
		( (TextView) this.findViewById(R.id.title_apft) ).setTextSize(FONT_SIZE);
		
		// Set label font sizes
		( (TextView) this.findViewById(R.id.label_gender) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_age) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_pushups) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_situps) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.time_separator) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_score) ).setTextSize(FONT_SIZE);		
		
		// Set up spinners
		spinner_gender = (Spinner) this.findViewById(R.id.spinner_gender);
		spinner_gender.setAdapter(adapter_gender);
		gender = spinner_gender.getSelectedItemPosition();
		
		spinner_age = (Spinner) this.findViewById(R.id.spinner_age);
		spinner_age.setAdapter(adapter_age_apft);
		age = spinner_age.getSelectedItemPosition();
		
		spinner_aerobic = (Spinner) this.findViewById(R.id.spinner_aerobic);
		spinner_aerobic.setAdapter(adapter_event_aerobic);
		event = spinner_aerobic.getSelectedItemPosition();
		
		// Set up text fields
		edittext_pushups = (EditText) this.findViewById(R.id.edittext_pushups);
		edittext_pushups.setTextSize(FONT_SIZE);
		edittext_pushups.requestFocus();
		
		edittext_situps = (EditText) this.findViewById(R.id.edittext_situps);
		edittext_situps.setTextSize(FONT_SIZE);
		
		edittext_minutes = (EditText) this.findViewById(R.id.edittext_minutes);
		edittext_minutes.setTextSize(FONT_SIZE);
		
		edittext_seconds = (EditText) this.findViewById(R.id.edittext_seconds);
		edittext_seconds.setTextSize(FONT_SIZE);
		
		// Set up output
		textview_alternate = (TextView) this.findViewById(R.id.label_alternate);
		textview_alternate.setTextSize(FONT_SIZE);
		switch(alternate) {
			case GO:
				textview_alternate.setTextColor(Color.GREEN);
				textview_alternate.setText("GO");
				break;
			case NOGO:
				textview_alternate.setTextColor(Color.RED);
				textview_alternate.setText("NO GO");
				break;
		}
		
		edittext_score = (EditText) this.findViewById(R.id.edittext_score);
		edittext_score.setTextSize(FONT_SIZE);
		
		// Set up buttons 
		button_back = (Button) this.findViewById(R.id.button_back);
		button_back.setTextSize(FONT_SIZE);		
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_main_menu();
			}        	
        });
		
		button_recalculate = (Button) this.findViewById(R.id.button_recalculate);
		button_recalculate.setTextSize(FONT_SIZE);		
		button_recalculate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate_score();
			}        	
        });
		
		spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				gender = position;
				calculate_score();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				age = position;
				calculate_score();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		spinner_aerobic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				event = position;
				calculate_score();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		edittext_pushups.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_score();
				return false;
			}
        });
		
		edittext_situps.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_score();
				return false;
			}
        });
		
		edittext_minutes.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_score();
				return false;
			}
        });
		
		edittext_seconds.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_score();
				return false;
			}
        });
	}
	
	private void show_weight_limits() {
		
		this.setContentView(screen_weight);
		screen_current = screen_weight;
		
		// Set title font size
		( (TextView) this.findViewById(R.id.title_weight) ).setTextSize(FONT_SIZE);
		
		// Set label font sizes
		( (TextView) this.findViewById(R.id.label_gender) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_age) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_height) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_minimum) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_maximum) ).setTextSize(FONT_SIZE);
		
		// Assign weights	
		maximum_weight.clear();
		maximum_weight.setProperty("58", "");
		maximum_weight.setProperty("59", "");
		maximum_weight.setProperty("60", "132");
		maximum_weight.setProperty("61", "136");
		maximum_weight.setProperty("62", "141");
		maximum_weight.setProperty("63", "145");
		maximum_weight.setProperty("64", "150");
		maximum_weight.setProperty("65", "155");
		maximum_weight.setProperty("66", "160");
		maximum_weight.setProperty("67", "165");
		maximum_weight.setProperty("68", "170");
		maximum_weight.setProperty("69", "175");
		maximum_weight.setProperty("70", "180");
		maximum_weight.setProperty("71", "185");
		maximum_weight.setProperty("72", "190");
		maximum_weight.setProperty("73", "195");
		maximum_weight.setProperty("74", "201");
		maximum_weight.setProperty("75", "206");
		maximum_weight.setProperty("76", "212");
		maximum_weight.setProperty("77", "218");
		maximum_weight.setProperty("78", "223");
		maximum_weight.setProperty("79", "229");
		maximum_weight.setProperty("80", "234");
		maximum_weight.setProperty("81", "240");
		maximum_weight.setProperty("82", "246");
		maximum_weight.setProperty("83", "252");
		maximum_weight.setProperty("84", "258");
		
		// Set up spinners
		spinner_gender = (Spinner) this.findViewById(R.id.spinner_gender);
		spinner_gender.setAdapter(adapter_gender);
		gender = spinner_gender.getSelectedItemPosition();
		
		spinner_age = (Spinner) this.findViewById(R.id.spinner_age);
		spinner_age.setAdapter(adapter_age_weight);
		age = spinner_age.getSelectedItemPosition();
		
		// Set up text fields
		edittext_height = (EditText) this.findViewById(R.id.edittext_height);
		edittext_height.setTextSize(FONT_SIZE);
		edittext_height.requestFocus();
		
		// Set up output
		edittext_minimum = (EditText) this.findViewById(R.id.edittext_minimum);
		edittext_minimum.setTextSize(FONT_SIZE);
		
		edittext_maximum = (EditText) this.findViewById(R.id.edittext_maximum);
		edittext_maximum.setTextSize(FONT_SIZE);
		
		// Set up buttons 
		button_back = (Button) this.findViewById(R.id.button_back);
		button_back.setTextSize(FONT_SIZE);		
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_main_menu();
			}        	
        });
		
		button_recalculate = (Button) this.findViewById(R.id.button_recalculate);
		button_recalculate.setTextSize(FONT_SIZE);		
		button_recalculate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate_weight();
			}        	
        });
		
		spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				gender = position;
				load_weight_list();
				calculate_weight();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				age = position;
				load_weight_list();
				calculate_weight();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		edittext_height.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_weight();
				return false;
			}
        });
		
	}
	
	private void show_bodyfat_calculator() {
		
		this.setContentView(screen_bodyfat);
		screen_current = screen_bodyfat;
		
		// Set title font size
		( (TextView) this.findViewById(R.id.title_bodyfat) ).setTextSize(FONT_SIZE);
		
		// Set label font sizes
		( (TextView) this.findViewById(R.id.label_gender) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_neck) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_waist) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_hips) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_height) ).setTextSize(FONT_SIZE);
		( (TextView) this.findViewById(R.id.label_percentage) ).setTextSize(FONT_SIZE);
		
		// Set up spinners
		spinner_gender = (Spinner) this.findViewById(R.id.spinner_gender);
		spinner_gender.setAdapter(adapter_gender);
		gender = spinner_gender.getSelectedItemPosition();		
		
		// Set up text fields
		edittext_neck = (EditText) this.findViewById(R.id.edittext_neck);
		edittext_neck.setTextSize(FONT_SIZE);
		edittext_neck.requestFocus();
		
		edittext_waist = (EditText) this.findViewById(R.id.edittext_waist);
		edittext_waist.setTextSize(FONT_SIZE);
		
		edittext_hips = (EditText) this.findViewById(R.id.edittext_hips);
		edittext_hips.setTextSize(FONT_SIZE);		
		
		edittext_height = (EditText) this.findViewById(R.id.edittext_height);
		edittext_height.setTextSize(FONT_SIZE);
		
		switch(gender) {
			case MALE:				
				int height_focus = edittext_height.getId();
				edittext_waist.setNextFocusDownId(height_focus);
				edittext_waist.setNextFocusRightId(height_focus);
				edittext_hips.setFocusableInTouchMode(false);
				edittext_hips.setFocusable(false);
				edittext_hips.setEnabled(false);
				break;
			case FEMALE:
				edittext_hips.setEnabled(true);
				edittext_hips.setFocusable(true);
				edittext_hips.setFocusableInTouchMode(true);
				int hips_focus = edittext_hips.getId();				
				edittext_waist.setNextFocusDownId(hips_focus);
				edittext_waist.setNextFocusRightId(hips_focus);				
				break;
		}
		
		// Set up output
		edittext_percentage = (EditText) this.findViewById(R.id.edittext_percentage);
		edittext_percentage.setTextSize(FONT_SIZE);
		
		// Set up buttons 
		button_back = (Button) this.findViewById(R.id.button_back);
		button_back.setTextSize(FONT_SIZE);		
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				show_main_menu();
			}        	
        });
		
		button_recalculate = (Button) this.findViewById(R.id.button_recalculate);
		button_recalculate.setTextSize(FONT_SIZE);		
		button_recalculate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate_body_fat();
			}        	
        });
		
		spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				gender = position;
				switch(gender) {
					case MALE:						
						int height_focus = edittext_height.getId();
						edittext_waist.setNextFocusDownId(height_focus);
						edittext_waist.setNextFocusRightId(height_focus);
						edittext_hips.setText("");
						if( edittext_hips.hasFocus() ) {
							edittext_height.requestFocus();
						}
						edittext_hips.setFocusableInTouchMode(false);
						edittext_hips.setFocusable(false);
						edittext_hips.setEnabled(false);
						break;
					case FEMALE:
						edittext_hips.setEnabled(true);
						edittext_hips.setFocusable(true);
						edittext_hips.setFocusableInTouchMode(true);
						int hips_focus = edittext_hips.getId();						
						edittext_waist.setNextFocusDownId(hips_focus);
						edittext_waist.setNextFocusRightId(hips_focus);
						edittext_hips.setText("");
						break;
				}
				calculate_body_fat();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// do noting
			}
		});
		
		edittext_neck.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_body_fat();
				return false;
			}
        });
		
		edittext_waist.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_body_fat();
				return false;
			}
        });
		
		edittext_height.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculate_body_fat();
				return false;
			}
        });
		
	}
	
	private void exit_app() {
		
		this.finish();		
		
	}
	
	private void load_weight_list() {
		
		switch(gender) {
			case MALE:
				switch(age) {
					case AGE_17to20:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "");
						maximum_weight.setProperty("59", "");
						maximum_weight.setProperty("60", "132");
						maximum_weight.setProperty("61", "136");
						maximum_weight.setProperty("62", "141");
						maximum_weight.setProperty("63", "145");
						maximum_weight.setProperty("64", "150");
						maximum_weight.setProperty("65", "155");
						maximum_weight.setProperty("66", "160");
						maximum_weight.setProperty("67", "165");
						maximum_weight.setProperty("68", "170");
						maximum_weight.setProperty("69", "175");
						maximum_weight.setProperty("70", "180");
						maximum_weight.setProperty("71", "185");
						maximum_weight.setProperty("72", "190");
						maximum_weight.setProperty("73", "195");
						maximum_weight.setProperty("74", "201");
						maximum_weight.setProperty("75", "206");
						maximum_weight.setProperty("76", "212");
						maximum_weight.setProperty("77", "218");
						maximum_weight.setProperty("78", "223");
						maximum_weight.setProperty("79", "229");
						maximum_weight.setProperty("80", "234");
						maximum_weight.setProperty("81", "240");
						maximum_weight.setProperty("82", "246");
						maximum_weight.setProperty("83", "252");
						maximum_weight.setProperty("84", "258");
						break;
					case AGE_21to27:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "");
						maximum_weight.setProperty("59", "");
						maximum_weight.setProperty("60", "136");
						maximum_weight.setProperty("61", "140");
						maximum_weight.setProperty("62", "144");
						maximum_weight.setProperty("63", "149");
						maximum_weight.setProperty("64", "154");
						maximum_weight.setProperty("65", "159");
						maximum_weight.setProperty("66", "163");
						maximum_weight.setProperty("67", "169");
						maximum_weight.setProperty("68", "174");
						maximum_weight.setProperty("69", "179");
						maximum_weight.setProperty("70", "185");
						maximum_weight.setProperty("71", "189");
						maximum_weight.setProperty("72", "195");
						maximum_weight.setProperty("73", "200");
						maximum_weight.setProperty("74", "206");
						maximum_weight.setProperty("75", "212");
						maximum_weight.setProperty("76", "217");
						maximum_weight.setProperty("77", "223");
						maximum_weight.setProperty("78", "229");
						maximum_weight.setProperty("79", "235");
						maximum_weight.setProperty("80", "240");
						maximum_weight.setProperty("81", "246");
						maximum_weight.setProperty("82", "252");
						maximum_weight.setProperty("83", "258");
						maximum_weight.setProperty("84", "264");
						break;
					case AGE_28to39:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "");
						maximum_weight.setProperty("59", "");
						maximum_weight.setProperty("60", "139");
						maximum_weight.setProperty("61", "144");
						maximum_weight.setProperty("62", "148");
						maximum_weight.setProperty("63", "153");
						maximum_weight.setProperty("64", "158");
						maximum_weight.setProperty("65", "163");
						maximum_weight.setProperty("66", "168");
						maximum_weight.setProperty("67", "174");
						maximum_weight.setProperty("68", "179");
						maximum_weight.setProperty("69", "184");
						maximum_weight.setProperty("70", "189");
						maximum_weight.setProperty("71", "194");
						maximum_weight.setProperty("72", "200");
						maximum_weight.setProperty("73", "205");
						maximum_weight.setProperty("74", "211");
						maximum_weight.setProperty("75", "217");
						maximum_weight.setProperty("76", "223");
						maximum_weight.setProperty("77", "229");
						maximum_weight.setProperty("78", "235");
						maximum_weight.setProperty("79", "241");
						maximum_weight.setProperty("80", "247");
						maximum_weight.setProperty("81", "253");
						maximum_weight.setProperty("82", "259");
						maximum_weight.setProperty("83", "265");
						maximum_weight.setProperty("84", "271");
						break;
					case AGE_40plus:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "");
						maximum_weight.setProperty("59", "");
						maximum_weight.setProperty("60", "141");
						maximum_weight.setProperty("61", "146");
						maximum_weight.setProperty("62", "150");
						maximum_weight.setProperty("63", "155");
						maximum_weight.setProperty("64", "160");
						maximum_weight.setProperty("65", "165");
						maximum_weight.setProperty("66", "170");
						maximum_weight.setProperty("67", "176");
						maximum_weight.setProperty("68", "181");
						maximum_weight.setProperty("69", "186");
						maximum_weight.setProperty("70", "192");
						maximum_weight.setProperty("71", "197");
						maximum_weight.setProperty("72", "203");
						maximum_weight.setProperty("73", "208");
						maximum_weight.setProperty("74", "214");
						maximum_weight.setProperty("75", "220");
						maximum_weight.setProperty("76", "226");
						maximum_weight.setProperty("77", "232");
						maximum_weight.setProperty("78", "238");
						maximum_weight.setProperty("79", "244");
						maximum_weight.setProperty("80", "250");
						maximum_weight.setProperty("81", "256");
						maximum_weight.setProperty("82", "262");
						maximum_weight.setProperty("83", "268");
						maximum_weight.setProperty("84", "274");
						break;
				}
				break;
			case FEMALE:
				switch(age) {
					case AGE_17to20:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "119");
						maximum_weight.setProperty("59", "124");
						maximum_weight.setProperty("60", "128");
						maximum_weight.setProperty("61", "132");
						maximum_weight.setProperty("62", "136");
						maximum_weight.setProperty("63", "141");
						maximum_weight.setProperty("64", "145");
						maximum_weight.setProperty("65", "150");
						maximum_weight.setProperty("66", "155");
						maximum_weight.setProperty("67", "159");
						maximum_weight.setProperty("68", "164");
						maximum_weight.setProperty("69", "169");
						maximum_weight.setProperty("70", "174");
						maximum_weight.setProperty("71", "179");
						maximum_weight.setProperty("72", "184");
						maximum_weight.setProperty("73", "189");
						maximum_weight.setProperty("74", "194");
						maximum_weight.setProperty("75", "200");
						maximum_weight.setProperty("76", "205");
						maximum_weight.setProperty("77", "210");
						maximum_weight.setProperty("78", "216");
						maximum_weight.setProperty("79", "221");
						maximum_weight.setProperty("80", "227");
						maximum_weight.setProperty("81", "232");
						maximum_weight.setProperty("82", "237");
						maximum_weight.setProperty("83", "242");
						maximum_weight.setProperty("84", "247");
						break;
					case AGE_21to27:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "121");
						maximum_weight.setProperty("59", "125");
						maximum_weight.setProperty("60", "129");
						maximum_weight.setProperty("61", "134");
						maximum_weight.setProperty("62", "138");
						maximum_weight.setProperty("63", "143");
						maximum_weight.setProperty("64", "147");
						maximum_weight.setProperty("65", "152");
						maximum_weight.setProperty("66", "156");
						maximum_weight.setProperty("67", "161");
						maximum_weight.setProperty("68", "166");
						maximum_weight.setProperty("69", "171");
						maximum_weight.setProperty("70", "176");
						maximum_weight.setProperty("71", "181");
						maximum_weight.setProperty("72", "186");
						maximum_weight.setProperty("73", "191");
						maximum_weight.setProperty("74", "197");
						maximum_weight.setProperty("75", "202");
						maximum_weight.setProperty("76", "207");
						maximum_weight.setProperty("77", "213");
						maximum_weight.setProperty("78", "218");
						maximum_weight.setProperty("79", "224");
						maximum_weight.setProperty("80", "230");
						maximum_weight.setProperty("81", "235");
						maximum_weight.setProperty("82", "240");
						maximum_weight.setProperty("83", "245");
						maximum_weight.setProperty("84", "250");
						break;
					case AGE_28to39:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "122");
						maximum_weight.setProperty("59", "126");
						maximum_weight.setProperty("60", "131");
						maximum_weight.setProperty("61", "135");
						maximum_weight.setProperty("62", "140");
						maximum_weight.setProperty("63", "144");
						maximum_weight.setProperty("64", "149");
						maximum_weight.setProperty("65", "154");
						maximum_weight.setProperty("66", "158");
						maximum_weight.setProperty("67", "163");
						maximum_weight.setProperty("68", "168");
						maximum_weight.setProperty("69", "173");
						maximum_weight.setProperty("70", "178");
						maximum_weight.setProperty("71", "183");
						maximum_weight.setProperty("72", "188");
						maximum_weight.setProperty("73", "194");
						maximum_weight.setProperty("74", "199");
						maximum_weight.setProperty("75", "204");
						maximum_weight.setProperty("76", "210");
						maximum_weight.setProperty("77", "215");
						maximum_weight.setProperty("78", "221");
						maximum_weight.setProperty("79", "227");
						maximum_weight.setProperty("80", "233");
						maximum_weight.setProperty("81", "238");
						maximum_weight.setProperty("82", "243");
						maximum_weight.setProperty("83", "248");
						maximum_weight.setProperty("84", "253");
						break;
					case AGE_40plus:
						maximum_weight.clear();
						maximum_weight.setProperty("58", "124");
						maximum_weight.setProperty("59", "128");
						maximum_weight.setProperty("60", "133");
						maximum_weight.setProperty("61", "137");
						maximum_weight.setProperty("62", "142");
						maximum_weight.setProperty("63", "146");
						maximum_weight.setProperty("64", "151");
						maximum_weight.setProperty("65", "156");
						maximum_weight.setProperty("66", "161");
						maximum_weight.setProperty("67", "166");
						maximum_weight.setProperty("68", "171");
						maximum_weight.setProperty("69", "176");
						maximum_weight.setProperty("70", "181");
						maximum_weight.setProperty("71", "186");
						maximum_weight.setProperty("72", "191");
						maximum_weight.setProperty("73", "197");
						maximum_weight.setProperty("74", "202");
						maximum_weight.setProperty("75", "208");
						maximum_weight.setProperty("76", "213");
						maximum_weight.setProperty("77", "219");
						maximum_weight.setProperty("78", "225");
						maximum_weight.setProperty("79", "230");
						maximum_weight.setProperty("80", "236");
						maximum_weight.setProperty("81", "241");
						maximum_weight.setProperty("82", "246");
						maximum_weight.setProperty("83", "251");
						maximum_weight.setProperty("84", "256");
						break;
				}
				break;
		}
		
	}
	
	private void calculate_weight() {
		
		String height =  edittext_height.getText().toString().trim();
		edittext_minimum.setText( minimum_weight.getProperty(height, "") );
		edittext_maximum.setText( maximum_weight.getProperty(height, "") );
		
	}
	
	private void calculate_body_fat() {

		int result = 0;
		float neck = 0;
		float waist = 0;
		float hips = 0;
		float height = 0;
		
		try{
			neck = Float.parseFloat( edittext_neck.getText().toString() );
		} catch(NumberFormatException ex) {
		}
		
		try{
			waist = Float.parseFloat( edittext_waist.getText().toString() );
		} catch(NumberFormatException ex) {
		}
		
		try{
			hips = Float.parseFloat( edittext_hips.getText().toString() );
		} catch(NumberFormatException ex) {
		}
		
		try{
			height = Float.parseFloat( edittext_height.getText().toString() );
		} catch(NumberFormatException ex) {
		}
		
		if( (neck > 0) && (waist > 0) && (height > 0) ) {
			switch(gender) {
				case MALE:
					result = Math.round( (float) ( 36.76 + ( 86.01 * Math.log10(waist - neck) ) - ( 70.041 * Math.log10(height) ) ) );
					break;
				case FEMALE:
					if(hips > 0) {
						result = Math.round( (float) ( ( 163.205 * Math.log10(waist + hips - neck) ) - ( 97.684 * Math.log10(height) ) - 78.387 ) );
					}
					break;
			}
		}
		
		if( result == 0 ) {
			edittext_percentage.setText("");
		} else {
			edittext_percentage.setText( String.valueOf(result) );
		}
		
	}
	
	private int calculate_pushups_male() {  // TODO

		int pushups = 0;
		int score = 0;
		
		try {
			pushups = Integer.parseInt( edittext_pushups.getText().toString() );
		} catch(NumberFormatException ex) {}
		
		switch(age) {
			case AGE_17to21:
				if(pushups > 4) {
					if(pushups < 71) {
						switch(pushups) {
							case 5:
								score = 9;
								break;
							case 6:
								score = 10;
								break;
							case 7:
								score = 12;
								break;
							case 8:
								score = 13;
								break;
							case 9:
								score = 14;
								break;
							case 10:
								score = 16;
								break;
							case 11:
								score = 17;
								break;
							case 12:
								score = 19;
								break;
							case 13:
								score = 20;
								break;
							case 14:
								score = 21;
								break;
							case 15:
								score = 23;
								break;
							case 16:
								score = 24;
								break;
							case 17:
								score = 26;
								break;
							case 18:
								score = 27;
								break;
							case 19:
								score = 28;
								break;
							case 20:
								score = 30;
								break;
							case 21:
								score = 31;
								break;
							case 22:
								score = 32;
								break;
							case 23:
								score = 34;
								break;
							case 24:
								score = 35;
								break;
							case 25:
								score = 37;
								break;
							case 26:
								score = 38;
								break;
							case 27:
								score = 39;
								break;
							case 28:
								score = 41;
								break;
							case 29:
								score = 42;
								break;
							case 30:
								score = 43;
								break;
							case 31:
								score = 45;
								break;
							case 32:
								score = 46;
								break;
							case 33:
								score = 48;
								break;
							case 34:
								score = 49;
								break;
							case 35:
								score = 50;
								break;
							case 36:
								score = 52;
								break;
							case 37:
								score = 53;
								break;
							case 38:
								score = 54;
								break;
							case 39:
								score = 56;
								break;
							case 40:
								score = 57;
								break;
							case 41:
								score = 59;
								break;
							case 42:
								score = 60;
								break;
							case 43:
								score = 61;
								break;
							case 44:
								score = 63;
								break;
							case 45:
								score = 64;
								break;
							case 46:
								score = 66;
								break;
							case 47:
								score = 67;
								break;
							case 48:
								score = 68;
								break;
							case 49:
								score = 70;
								break;
							case 50:
								score = 71;
								break;
							case 51:
								score = 72;
								break;
							case 52:
								score = 74;
								break;
							case 53:
								score = 75;
								break;
							case 54:
								score = 77;
								break;
							case 55:
								score = 78;
								break;
							case 56:
								score = 79;
								break;
							case 57:
								score = 81;
								break;
							case 58:
								score = 82;
								break;
							case 59:
								score = 83;
								break;
							case 60:
								score = 85;
								break;
							case 61:
								score = 86;
								break;
							case 62:
								score = 88;
								break;
							case 63:
								score = 89;
								break;
							case 64:
								score = 90;
								break;
							case 65:
								score = 92;
								break;
							case 66:
								score = 93;
								break;
							case 67:
								score = 94;
								break;
							case 68:
								score = 96;
								break;
							case 69:
								score = 97;
								break;
							case 70:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_22to26:
				if(pushups > 4) {
					if(pushups < 75) {
						switch(pushups) {
							case 5:
								score = 20;
								break;
							case 6:
								score = 21;
								break;
							case 7:
								score = 22;
								break;
							case 8:
								score = 23;
								break;
							case 9:
								score = 25;
								break;
							case 10:
								score = 26;
								break;
							case 11:
								score = 27;
								break;
							case 12:
								score = 28;
								break;
							case 13:
								score = 29;
								break;
							case 14:
								score = 30;
								break;
							case 15:
								score = 31;
								break;
							case 16:
								score = 33;
								break;
							case 17:
								score = 34;
								break;
							case 18:
								score = 35;
								break;
							case 19:
								score = 36;
								break;
							case 20:
								score = 37;
								break;
							case 21:
								score = 38;
								break;
							case 22:
								score = 39;
								break;
							case 23:
								score = 41;
								break;
							case 24:
								score = 42;
								break;
							case 25:
								score = 43;
								break;
							case 26:
								score = 44;
								break;
							case 27:
								score = 45;
								break;
							case 28:
								score = 46;
								break;
							case 29:
								score = 47;
								break;
							case 30:
								score = 49;
								break;
							case 31:
								score = 50;
								break;
							case 32:
								score = 51;
								break;
							case 33:
								score = 52;
								break;
							case 34:
								score = 53;
								break;
							case 35:
								score = 54;
								break;
							case 36:
								score = 55;
								break;
							case 37:
								score = 57;
								break;
							case 38:
								score = 58;
								break;
							case 39:
								score = 59;
								break;
							case 40:
								score = 60;
								break;
							case 41:
								score = 61;
								break;
							case 42:
								score = 62;
								break;
							case 43:
								score = 63;
								break;
							case 44:
								score = 65;
								break;
							case 45:
								score = 66;
								break;
							case 46:
								score = 67;
								break;
							case 47:
								score = 68;
								break;
							case 48:
								score = 69;
								break;
							case 49:
								score = 70;
								break;
							case 50:
								score = 71;
								break;
							case 51:
								score = 73;
								break;
							case 52:
								score = 74;
								break;
							case 53:
								score = 75;
								break;
							case 54:
								score = 76;
								break;
							case 55:
								score = 77;
								break;
							case 56:
								score = 78;
								break;
							case 57:
								score = 79;
								break;
							case 58:
								score = 81;
								break;
							case 59:
								score = 82;
								break;
							case 60:
								score = 83;
								break;
							case 61:
								score = 84;
								break;
							case 62:
								score = 85;
								break;
							case 63:
								score = 86;
								break;
							case 64:
								score = 87;
								break;
							case 65:
								score = 89;
								break;
							case 66:
								score = 90;
								break;
							case 67:
								score = 91;
								break;
							case 68:
								score = 92;
								break;
							case 69:
								score = 93;
								break;
							case 70:
								score = 94;
								break;
							case 71:
								score = 95;
								break;
							case 72:
								score = 97;
								break;
							case 73:
								score = 98;
								break;
							case 74:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_27to31:
				if(pushups > 4) {
					if(pushups < 77) {
						switch(pushups) {
							case 5:
								score = 24;
								break;
							case 6:
								score = 25;
								break;
							case 7:
								score = 26;
								break;
							case 8:
								score = 27;
								break;
							case 9:
								score = 28;
								break;
							case 10:
								score = 29;
								break;
							case 11:
								score = 31;
								break;
							case 12:
								score = 32;
								break;
							case 13:
								score = 33;
								break;
							case 14:
								score = 34;
								break;
							case 15:
								score = 35;
								break;
							case 16:
								score = 36;
								break;
							case 17:
								score = 37;
								break;
							case 18:
								score = 38;
								break;
							case 19:
								score = 39;
								break;
							case 20:
								score = 40;
								break;
							case 21:
								score = 41;
								break;
							case 22:
								score = 42;
								break;
							case 23:
								score = 43;
								break;
							case 24:
								score = 44;
								break;
							case 25:
								score = 45;
								break;
							case 26:
								score = 46;
								break;
							case 27:
								score = 47;
								break;
							case 28:
								score = 48;
								break;
							case 29:
								score = 49;
								break;
							case 30:
								score = 50;
								break;
							case 31:
								score = 52;
								break;
							case 32:
								score = 53;
								break;
							case 33:
								score = 54;
								break;
							case 34:
								score = 55;
								break;
							case 35:
								score = 56;
								break;
							case 36:
								score = 57;
								break;
							case 37:
								score = 58;
								break;
							case 38:
								score = 59;
								break;
							case 39:
								score = 60;
								break;
							case 40:
								score = 61;
								break;
							case 41:
								score = 62;
								break;
							case 42:
								score = 63;
								break;
							case 43:
								score = 64;
								break;
							case 44:
								score = 65;
								break;
							case 45:
								score = 66;
								break;
							case 46:
								score = 67;
								break;
							case 47:
								score = 68;
								break;
							case 48:
								score = 69;
								break;
							case 49:
								score = 71;
								break;
							case 50:
								score = 72;
								break;
							case 51:
								score = 73;
								break;
							case 52:
								score = 74;
								break;
							case 53:
								score = 75;
								break;
							case 54:
								score = 76;
								break;
							case 55:
								score = 77;
								break;
							case 56:
								score = 78;
								break;
							case 57:
								score = 79;
								break;
							case 58:
								score = 80;
								break;
							case 59:
								score = 81;
								break;
							case 60:
								score = 82;
								break;
							case 61:
								score = 83;
								break;
							case 62:
								score = 84;
								break;
							case 63:
								score = 85;
								break;
							case 64:
								score = 86;
								break;
							case 65:
								score = 87;
								break;
							case 66:
								score = 88;
								break;
							case 67:
								score = 89;
								break;
							case 68:
								score = 91;
								break;
							case 69:
								score = 92;
								break;
							case 70:
								score = 93;
								break;
							case 71:
								score = 94;
								break;
							case 72:
								score = 95;
								break;
							case 73:
								score = 96;
								break;
							case 74:
								score = 97;
								break;
							case 75:
								score = 98;
								break;
							case 76:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_32to36:
				if(pushups > 4) {
					if(pushups < 75) {
						switch(pushups) {
							case 5:
								score = 28;
								break;
							case 6:
								score = 29;
								break;
							case 7:
								score = 30;
								break;
							case 8:
								score = 31;
								break;
							case 9:
								score = 32;
								break;
							case 10:
								score = 33;
								break;
							case 11:
								score = 34;
								break;
							case 12:
								score = 35;
								break;
							case 13:
								score = 36;
								break;
							case 14:
								score = 37;
								break;
							case 15:
								score = 38;
								break;
							case 16:
								score = 39;
								break;
							case 17:
								score = 41;
								break;
							case 18:
								score = 42;
								break;
							case 19:
								score = 43;
								break;
							case 20:
								score = 44;
								break;
							case 21:
								score = 45;
								break;
							case 22:
								score = 46;
								break;
							case 23:
								score = 47;
								break;
							case 24:
								score = 48;
								break;
							case 25:
								score = 49;
								break;
							case 26:
								score = 50;
								break;
							case 27:
								score = 51;
								break;
							case 28:
								score = 52;
								break;
							case 29:
								score = 53;
								break;
							case 30:
								score = 54;
								break;
							case 31:
								score = 55;
								break;
							case 32:
								score = 56;
								break;
							case 33:
								score = 57;
								break;
							case 34:
								score = 58;
								break;
							case 35:
								score = 59;
								break;
							case 36:
								score = 60;
								break;
							case 37:
								score = 61;
								break;
							case 38:
								score = 62;
								break;
							case 39:
								score = 63;
								break;
							case 40:
								score = 64;
								break;
							case 41:
								score = 65;
								break;
							case 42:
								score = 66;
								break;
							case 43:
								score = 67;
								break;
							case 44:
								score = 68;
								break;
							case 45:
								score = 69;
								break;
							case 46:
								score = 70;
								break;
							case 47:
								score = 71;
								break;
							case 48:
								score = 72;
								break;
							case 49:
								score = 73;
								break;
							case 50:
								score = 74;
								break;
							case 51:
								score = 75;
								break;
							case 52:
								score = 76;
								break;
							case 53:
								score = 77;
								break;
							case 54:
								score = 78;
								break;
							case 55:
								score = 79;
								break;
							case 56:
								score = 81;
								break;
							case 57:
								score = 82;
								break;
							case 58:
								score = 83;
								break;
							case 59:
								score = 84;
								break;
							case 60:
								score = 85;
								break;
							case 61:
								score = 86;
								break;
							case 62:
								score = 87;
								break;
							case 63:
								score = 88;
								break;
							case 64:
								score = 89;
								break;
							case 65:
								score = 90;
								break;
							case 66:
								score = 91;
								break;
							case 67:
								score = 92;
								break;
							case 68:
								score = 93;
								break;
							case 69:
								score = 94;
								break;
							case 70:
								score = 95;
								break;
							case 71:
								score = 96;
								break;
							case 72:
								score = 97;
								break;
							case 73:
								score = 98;
								break;
							case 74:
								score = 99;
								break;
							case 75:
								score = 100;
								break;
							case 76:
								score = 100;
								break;
							case 77:
								score = 100;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_37to41:
				if(pushups > 4) {
					if(pushups < 73) {
						switch(pushups) {
							case 5:
								score = 30;
								break;
							case 6:
								score = 31;
								break;
							case 7:
								score = 32;
								break;
							case 8:
								score = 33;
								break;
							case 9:
								score = 34;
								break;
							case 10:
								score = 35;
								break;
							case 11:
								score = 36;
								break;
							case 12:
								score = 37;
								break;
							case 13:
								score = 38;
								break;
							case 14:
								score = 39;
								break;
							case 15:
								score = 41;
								break;
							case 16:
								score = 42;
								break;
							case 17:
								score = 43;
								break;
							case 18:
								score = 44;
								break;
							case 19:
								score = 45;
								break;
							case 20:
								score = 46;
								break;
							case 21:
								score = 47;
								break;
							case 22:
								score = 48;
								break;
							case 23:
								score = 49;
								break;
							case 24:
								score = 50;
								break;
							case 25:
								score = 51;
								break;
							case 26:
								score = 52;
								break;
							case 27:
								score = 53;
								break;
							case 28:
								score = 54;
								break;
							case 29:
								score = 55;
								break;
							case 30:
								score = 56;
								break;
							case 31:
								score = 57;
								break;
							case 32:
								score = 58;
								break;
							case 33:
								score = 59;
								break;
							case 34:
								score = 60;
								break;
							case 35:
								score = 61;
								break;
							case 36:
								score = 62;
								break;
							case 37:
								score = 63;
								break;
							case 38:
								score = 64;
								break;
							case 39:
								score = 65;
								break;
							case 40:
								score = 66;
								break;
							case 41:
								score = 67;
								break;
							case 42:
								score = 68;
								break;
							case 43:
								score = 69;
								break;
							case 44:
								score = 70;
								break;
							case 45:
								score = 71;
								break;
							case 46:
								score = 72;
								break;
							case 47:
								score = 73;
								break;
							case 48:
								score = 74;
								break;
							case 49:
								score = 75;
								break;
							case 50:
								score = 76;
								break;
							case 51:
								score = 77;
								break;
							case 52:
								score = 78;
								break;
							case 53:
								score = 79;
								break;
							case 54:
								score = 81;
								break;
							case 55:
								score = 82;
								break;
							case 56:
								score = 83;
								break;
							case 57:
								score = 84;
								break;
							case 58:
								score = 85;
								break;
							case 59:
								score = 86;
								break;
							case 60:
								score = 87;
								break;
							case 61:
								score = 88;
								break;
							case 62:
								score = 89;
								break;
							case 63:
								score = 90;
								break;
							case 64:
								score = 91;
								break;
							case 65:
								score = 92;
								break;
							case 66:
								score = 93;
								break;
							case 67:
								score = 94;
								break;
							case 68:
								score = 95;
								break;
							case 69:
								score = 96;
								break;
							case 70:
								score = 97;
								break;
							case 71:
								score = 98;
								break;
							case 72:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_42to46:
				if(pushups > 4) {
					if(pushups < 66) {
						switch(pushups) {
							case 5:
								score = 32;
								break;
							case 6:
								score = 33;
								break;
							case 7:
								score = 34;
								break;
							case 8:
								score = 36;
								break;
							case 9:
								score = 37;
								break;
							case 10:
								score = 38;
								break;
							case 11:
								score = 39;
								break;
							case 12:
								score = 40;
								break;
							case 13:
								score = 41;
								break;
							case 14:
								score = 42;
								break;
							case 15:
								score = 43;
								break;
							case 16:
								score = 44;
								break;
							case 17:
								score = 46;
								break;
							case 18:
								score = 47;
								break;
							case 19:
								score = 48;
								break;
							case 20:
								score = 49;
								break;
							case 21:
								score = 50;
								break;
							case 22:
								score = 51;
								break;
							case 23:
								score = 52;
								break;
							case 24:
								score = 53;
								break;
							case 25:
								score = 54;
								break;
							case 26:
								score = 56;
								break;
							case 27:
								score = 57;
								break;
							case 28:
								score = 58;
								break;
							case 29:
								score = 59;
								break;
							case 30:
								score = 60;
								break;
							case 31:
								score = 61;
								break;
							case 32:
								score = 62;
								break;
							case 33:
								score = 63;
								break;
							case 34:
								score = 64;
								break;
							case 35:
								score = 66;
								break;
							case 36:
								score = 67;
								break;
							case 37:
								score = 68;
								break;
							case 38:
								score = 69;
								break;
							case 39:
								score = 70;
								break;
							case 40:
								score = 71;
								break;
							case 41:
								score = 72;
								break;
							case 42:
								score = 73;
								break;
							case 43:
								score = 74;
								break;
							case 44:
								score = 76;
								break;
							case 45:
								score = 77;
								break;
							case 46:
								score = 78;
								break;
							case 47:
								score = 79;
								break;
							case 48:
								score = 80;
								break;
							case 49:
								score = 81;
								break;
							case 50:
								score = 82;
								break;
							case 51:
								score = 83;
								break;
							case 52:
								score = 84;
								break;
							case 53:
								score = 86;
								break;
							case 54:
								score = 87;
								break;
							case 55:
								score = 88;
								break;
							case 56:
								score = 89;
								break;
							case 57:
								score = 90;
								break;
							case 58:
								score = 91;
								break;
							case 59:
								score = 92;
								break;
							case 60:
								score = 93;
								break;
							case 61:
								score = 94;
								break;
							case 62:
								score = 96;
								break;
							case 63:
								score = 97;
								break;
							case 64:
								score = 98;
								break;
							case 65:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_47to51:
				if(pushups > 4) {
					if(pushups < 59) {
						switch(pushups) {
							case 5:
								score = 36;
								break;
							case 6:
								score = 38;
								break;
							case 7:
								score = 39;
								break;
							case 8:
								score = 40;
								break;
							case 9:
								score = 41;
								break;
							case 10:
								score = 42;
								break;
							case 11:
								score = 44;
								break;
							case 12:
								score = 45;
								break;
							case 13:
								score = 46;
								break;
							case 14:
								score = 47;
								break;
							case 15:
								score = 48;
								break;
							case 16:
								score = 49;
								break;
							case 17:
								score = 51;
								break;
							case 18:
								score = 52;
								break;
							case 19:
								score = 53;
								break;
							case 20:
								score = 54;
								break;
							case 21:
								score = 55;
								break;
							case 22:
								score = 56;
								break;
							case 23:
								score = 58;
								break;
							case 24:
								score = 59;
								break;
							case 25:
								score = 60;
								break;
							case 26:
								score = 61;
								break;
							case 27:
								score = 62;
								break;
							case 28:
								score = 64;
								break;
							case 29:
								score = 65;
								break;
							case 30:
								score = 66;
								break;
							case 31:
								score = 67;
								break;
							case 32:
								score = 68;
								break;
							case 33:
								score = 69;
								break;
							case 34:
								score = 71;
								break;
							case 35:
								score = 72;
								break;
							case 36:
								score = 73;
								break;
							case 37:
								score = 74;
								break;
							case 38:
								score = 75;
								break;
							case 39:
								score = 76;
								break;
							case 40:
								score = 78;
								break;
							case 41:
								score = 79;
								break;
							case 42:
								score = 80;
								break;
							case 43:
								score = 81;
								break;
							case 44:
								score = 82;
								break;
							case 45:
								score = 84;
								break;
							case 46:
								score = 85;
								break;
							case 47:
								score = 86;
								break;
							case 48:
								score = 87;
								break;
							case 49:
								score = 88;
								break;
							case 50:
								score = 89;
								break;
							case 51:
								score = 91;
								break;
							case 52:
								score = 92;
								break;
							case 53:
								score = 93;
								break;
							case 54:
								score = 94;
								break;
							case 55:
								score = 95;
								break;
							case 56:
								score = 96;
								break;
							case 57:
								score = 98;
								break;
							case 58:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_52to56:
				if(pushups > 4) {
					if(pushups < 56) {
						switch(pushups) {
							case 5:
								score = 43;
								break;
							case 6:
								score = 44;
								break;
							case 7:
								score = 46;
								break;
							case 8:
								score = 47;
								break;
							case 9:
								score = 48;
								break;
							case 10:
								score = 49;
								break;
							case 11:
								score = 50;
								break;
							case 12:
								score = 51;
								break;
							case 13:
								score = 52;
								break;
							case 14:
								score = 53;
								break;
							case 15:
								score = 54;
								break;
							case 16:
								score = 56;
								break;
							case 17:
								score = 57;
								break;
							case 18:
								score = 58;
								break;
							case 19:
								score = 59;
								break;
							case 20:
								score = 60;
								break;
							case 21:
								score = 61;
								break;
							case 22:
								score = 62;
								break;
							case 23:
								score = 63;
								break;
							case 24:
								score = 64;
								break;
							case 25:
								score = 66;
								break;
							case 26:
								score = 67;
								break;
							case 27:
								score = 68;
								break;
							case 28:
								score = 69;
								break;
							case 29:
								score = 70;
								break;
							case 30:
								score = 71;
								break;
							case 31:
								score = 72;
								break;
							case 32:
								score = 73;
								break;
							case 33:
								score = 74;
								break;
							case 34:
								score = 76;
								break;
							case 35:
								score = 77;
								break;
							case 36:
								score = 78;
								break;
							case 37:
								score = 79;
								break;
							case 38:
								score = 80;
								break;
							case 39:
								score = 81;
								break;
							case 40:
								score = 82;
								break;
							case 41:
								score = 83;
								break;
							case 42:
								score = 84;
								break;
							case 43:
								score = 86;
								break;
							case 44:
								score = 87;
								break;
							case 45:
								score = 88;
								break;
							case 46:
								score = 89;
								break;
							case 47:
								score = 90;
								break;
							case 48:
								score = 91;
								break;
							case 49:
								score = 92;
								break;
							case 50:
								score = 93;
								break;
							case 51:
								score = 94;
								break;
							case 52:
								score = 96;
								break;
							case 53:
								score = 97;
								break;
							case 54:
								score = 98;
								break;
							case 55:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_57to61:
				if(pushups > 4) {
					if(pushups < 53) {
						switch(pushups) {
							case 5:
								score = 45;
								break;
							case 6:
								score = 46;
								break;
							case 7:
								score = 47;
								break;
							case 8:
								score = 49;
								break;
							case 9:
								score = 50;
								break;
							case 10:
								score = 51;
								break;
							case 11:
								score = 52;
								break;
							case 12:
								score = 53;
								break;
							case 13:
								score = 54;
								break;
							case 14:
								score = 55;
								break;
							case 15:
								score = 57;
								break;
							case 16:
								score = 58;
								break;
							case 17:
								score = 59;
								break;
							case 18:
								score = 60;
								break;
							case 19:
								score = 61;
								break;
							case 20:
								score = 62;
								break;
							case 21:
								score = 63;
								break;
							case 22:
								score = 65;
								break;
							case 23:
								score = 66;
								break;
							case 24:
								score = 67;
								break;
							case 25:
								score = 68;
								break;
							case 26:
								score = 69;
								break;
							case 27:
								score = 70;
								break;
							case 28:
								score = 71;
								break;
							case 29:
								score = 73;
								break;
							case 30:
								score = 74;
								break;
							case 31:
								score = 75;
								break;
							case 32:
								score = 76;
								break;
							case 33:
								score = 77;
								break;
							case 34:
								score = 78;
								break;
							case 35:
								score = 79;
								break;
							case 36:
								score = 81;
								break;
							case 37:
								score = 82;
								break;
							case 38:
								score = 83;
								break;
							case 39:
								score = 84;
								break;
							case 40:
								score = 85;
								break;
							case 41:
								score = 86;
								break;
							case 42:
								score = 87;
								break;
							case 43:
								score = 89;
								break;
							case 44:
								score = 90;
								break;
							case 45:
								score = 91;
								break;
							case 46:
								score = 92;
								break;
							case 47:
								score = 93;
								break;
							case 48:
								score = 94;
								break;
							case 49:
								score = 95;
								break;
							case 50:
								score = 97;
								break;
							case 51:
								score = 98;
								break;
							case 52:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_62andup:
				if(pushups > 4) {
					if(pushups < 50) {
						switch(pushups) {
							case 5:
								score = 47;
								break;
							case 6:
								score = 48;
								break;
							case 7:
								score = 49;
								break;
							case 8:
								score = 51;
								break;
							case 9:
								score = 52;
								break;
							case 10:
								score = 53;
								break;
							case 11:
								score = 54;
								break;
							case 12:
								score = 55;
								break;
							case 13:
								score = 56;
								break;
							case 14:
								score = 58;
								break;
							case 15:
								score = 59;
								break;
							case 16:
								score = 60;
								break;
							case 17:
								score = 61;
								break;
							case 18:
								score = 62;
								break;
							case 19:
								score = 64;
								break;
							case 20:
								score = 65;
								break;
							case 21:
								score = 66;
								break;
							case 22:
								score = 67;
								break;
							case 23:
								score = 68;
								break;
							case 24:
								score = 69;
								break;
							case 25:
								score = 71;
								break;
							case 26:
								score = 72;
								break;
							case 27:
								score = 73;
								break;
							case 28:
								score = 74;
								break;
							case 29:
								score = 75;
								break;
							case 30:
								score = 76;
								break;
							case 31:
								score = 78;
								break;
							case 32:
								score = 79;
								break;
							case 33:
								score = 80;
								break;
							case 34:
								score = 81;
								break;
							case 35:
								score = 82;
								break;
							case 36:
								score = 84;
								break;
							case 37:
								score = 85;
								break;
							case 38:
								score = 86;
								break;
							case 39:
								score = 87;
								break;
							case 40:
								score = 88;
								break;
							case 41:
								score = 89;
								break;
							case 42:
								score = 91;
								break;
							case 43:
								score = 92;
								break;
							case 44:
								score = 93;
								break;
							case 45:
								score = 94;
								break;
							case 46:
								score = 95;
								break;
							case 47:
								score = 96;
								break;
							case 48:
								score = 98;
								break;
							case 49:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
		}
		
		return score;

	}
	
	private int calculate_situps() {  // TODO

		int situps = 0;
		int score = 0;
		
		try {
			situps = Integer.parseInt( edittext_situps.getText().toString() );
		} catch(NumberFormatException ex) {}
		
		switch(age) {
			case AGE_17to21:
				if(situps > 20) {
					if(situps < 78) {
						switch(situps) {
							case 21:
								score = 9;
								break;
							case 22:
								score = 10;
								break;
							case 23:
								score = 12;
								break;
							case 24:
								score = 14;
								break;
							case 25:
								score = 15;
								break;
							case 26:
								score = 17;
								break;
							case 27:
								score = 18;
								break;
							case 28:
								score = 20;
								break;
							case 29:
								score = 22;
								break;
							case 30:
								score = 23;
								break;
							case 31:
								score = 25;
								break;
							case 32:
								score = 26;
								break;
							case 33:
								score = 28;
								break;
							case 34:
								score = 30;
								break;
							case 35:
								score = 31;
								break;
							case 36:
								score = 33;
								break;
							case 37:
								score = 34;
								break;
							case 38:
								score = 36;
								break;
							case 39:
								score = 38;
								break;
							case 40:
								score = 39;
								break;
							case 41:
								score = 41;
								break;
							case 42:
								score = 42;
								break;
							case 43:
								score = 44;
								break;
							case 44:
								score = 46;
								break;
							case 45:
								score = 47;
								break;
							case 46:
								score = 49;
								break;
							case 47:
								score = 50;
								break;
							case 48:
								score = 52;
								break;
							case 49:
								score = 54;
								break;
							case 50:
								score = 55;
								break;
							case 51:
								score = 57;
								break;
							case 52:
								score = 58;
								break;
							case 53:
								score = 60;
								break;
							case 54:
								score = 62;
								break;
							case 55:
								score = 63;
								break;
							case 56:
								score = 65;
								break;
							case 57:
								score = 66;
								break;
							case 58:
								score = 68;
								break;
							case 59:
								score = 70;
								break;
							case 60:
								score = 71;
								break;
							case 61:
								score = 73;
								break;
							case 62:
								score = 74;
								break;
							case 63:
								score = 76;
								break;
							case 64:
								score = 78;
								break;
							case 65:
								score = 79;
								break;
							case 66:
								score = 81;
								break;
							case 67:
								score = 82;
								break;
							case 68:
								score = 84;
								break;
							case 69:
								score = 86;
								break;
							case 70:
								score = 87;
								break;
							case 71:
								score = 89;
								break;
							case 72:
								score = 90;
								break;
							case 73:
								score = 92;
								break;
							case 74:
								score = 94;
								break;
							case 75:
								score = 95;
								break;
							case 76:
								score = 97;
								break;
							case 77:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_22to26:
				if(situps > 20) {
					if(situps < 80) {
						switch(situps) {
							case 21:
								score = 21;
								 break;
							case 22:
								score = 23;
								 break;
							case 23:
								score = 24;
								 break;
							case 24:
								score = 25;
								 break;
							case 25:
								score = 27;
								 break;
							case 26:
								score = 28;
								 break;
							case 27:
								score = 29;
								 break;
							case 28:
								score = 31;
								 break;
							case 29:
								score = 32;
								 break;
							case 30:
								score = 33;
								 break;
							case 31:
								score = 35;
								 break;
							case 32:
								score = 36;
								 break;
							case 33:
								score = 37;
								 break;
							case 34:
								score = 39;
								 break;
							case 35:
								score = 40;
								 break;
							case 36:
								score = 41;
								 break;
							case 37:
								score = 43;
								 break;
							case 38:
								score = 44;
								 break;
							case 39:
								score = 45;
								 break;
							case 40:
								score = 47;
								 break;
							case 41:
								score = 48;
								 break;
							case 42:
								score = 49;
								 break;
							case 43:
								score = 50;
								 break;
							case 44:
								score = 52;
								 break;
							case 45:
								score = 53;
								 break;
							case 46:
								score = 55;
								 break;
							case 47:
								score = 56;
								 break;
							case 48:
								score = 57;
								 break;
							case 49:
								score = 59;
								 break;
							case 50:
								score = 60;
								 break;
							case 51:
								score = 61;
								 break;
							case 52:
								score = 63;
								 break;
							case 53:
								score = 64;
								 break;
							case 54:
								score = 65;
								 break;
							case 55:
								score = 67;
								 break;
							case 56:
								score = 68;
								 break;
							case 57:
								score = 69;
								 break;
							case 58:
								score = 71;
								 break;
							case 59:
								score = 72;
								 break;
							case 60:
								score = 73;
								 break;
							case 61:
								score = 75;
								 break;
							case 62:
								score = 76;
								 break;
							case 63:
								score = 77;
								 break;
							case 64:
								score = 79;
								 break;
							case 65:
								score = 80;
								 break;
							case 66:
								score = 81;
								 break;
							case 67:
								score = 83;
								 break;
							case 68:
								score = 84;
								 break;
							case 69:
								score = 85;
								 break;
							case 70:
								score = 87;
								 break;
							case 71:
								score = 88;
								 break;
							case 72:
								score = 89;
								 break;
							case 73:
								score = 91;
								 break;
							case 74:
								score = 92;
								 break;
							case 75:
								score = 93;
								 break;
							case 76:
								score = 95;
								 break;
							case 77:
								score = 96;
								 break;
							case 78:
								score = 97;
								 break;
							case 79:
								score = 99;
								 break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_27to31:
				if(situps > 20) {
					if(situps < 82) {
						switch(situps) {
							case 21:
								score = 34;
								break;
							case 22:
								score = 35;
								break;
							case 23:
								score = 36;
								break;
							case 24:
								score = 37;
								break;
							case 25:
								score = 38;
								break;
							case 26:
								score = 39;
								break;
							case 27:
								score = 41;
								break;
							case 28:
								score = 42;
								break;
							case 29:
								score = 43;
								break;
							case 30:
								score = 44;
								break;
							case 31:
								score = 45;
								break;
							case 32:
								score = 46;
								break;
							case 33:
								score = 47;
								break;
							case 34:
								score = 48;
								break;
							case 35:
								score = 49;
								break;
							case 36:
								score = 50;
								break;
							case 37:
								score = 51;
								break;
							case 38:
								score = 52;
								break;
							case 39:
								score = 54;
								break;
							case 40:
								score = 55;
								break;
							case 41:
								score = 56;
								break;
							case 42:
								score = 57;
								break;
							case 43:
								score = 58;
								break;
							case 44:
								score = 59;
								break;
							case 45:
								score = 60;
								break;
							case 46:
								score = 61;
								break;
							case 47:
								score = 62;
								break;
							case 48:
								score = 63;
								break;
							case 49:
								score = 64;
								break;
							case 50:
								score = 65;
								break;
							case 51:
								score = 66;
								break;
							case 52:
								score = 68;
								break;
							case 53:
								score = 69;
								break;
							case 54:
								score = 70;
								break;
							case 55:
								score = 71;
								break;
							case 56:
								score = 72;
								break;
							case 57:
								score = 73;
								break;
							case 58:
								score = 74;
								break;
							case 59:
								score = 75;
								break;
							case 60:
								score = 76;
								break;
							case 61:
								score = 77;
								break;
							case 62:
								score = 78;
								break;
							case 63:
								score = 79;
								break;
							case 64:
								score = 81;
								break;
							case 65:
								score = 82;
								break;
							case 66:
								score = 83;
								break;
							case 67:
								score = 84;
								break;
							case 68:
								score = 85;
								break;
							case 69:
								score = 86;
								break;
							case 70:
								score = 87;
								break;
							case 71:
								score = 88;
								break;
							case 72:
								score = 89;
								break;
							case 73:
								score = 90;
								break;
							case 74:
								score = 91;
								break;
							case 75:
								score = 92;
								break;
							case 76:
								score = 94;
								break;
							case 77:
								score = 95;
								break;
							case 78:
								score = 96;
								break;
							case 79:
								score = 97;
								break;
							case 80:
								score = 98;
								break;
							case 81:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_32to36:
				if(situps > 20) {
					if(situps < 76) {
						switch(situps) {
							case 21:
								score = 35;
								break;
							case 22:
								score = 36;
								break;
							case 23:
								score = 38;
								break;
							case 24:
								score = 39;
								break;
							case 25:
								score = 40;
								break;
							case 26:
								score = 41;
								break;
							case 27:
								score = 42;
								break;
							case 28:
								score = 44;
								break;
							case 29:
								score = 45;
								break;
							case 30:
								score = 46;
								break;
							case 31:
								score = 47;
								break;
							case 32:
								score = 48;
								break;
							case 33:
								score = 49;
								break;
							case 34:
								score = 50;
								break;
							case 35:
								score = 52;
								break;
							case 36:
								score = 53;
								break;
							case 37:
								score = 54;
								break;
							case 38:
								score = 55;
								break;
							case 39:
								score = 56;
								break;
							case 40:
								score = 58;
								break;
							case 41:
								score = 59;
								break;
							case 42:
								score = 60;
								break;
							case 43:
								score = 61;
								break;
							case 44:
								score = 62;
								break;
							case 45:
								score = 64;
								break;
							case 46:
								score = 65;
								break;
							case 47:
								score = 66;
								break;
							case 48:
								score = 67;
								break;
							case 49:
								score = 68;
								break;
							case 50:
								score = 69;
								break;
							case 51:
								score = 71;
								break;
							case 52:
								score = 72;
								break;
							case 53:
								score = 73;
								break;
							case 54:
								score = 74;
								break;
							case 55:
								score = 75;
								break;
							case 56:
								score = 76;
								break;
							case 57:
								score = 78;
								break;
							case 58:
								score = 79;
								break;
							case 59:
								score = 80;
								break;
							case 60:
								score = 81;
								break;
							case 61:
								score = 82;
								break;
							case 62:
								score = 84;
								break;
							case 63:
								score = 85;
								break;
							case 64:
								score = 86;
								break;
							case 65:
								score = 87;
								break;
							case 66:
								score = 88;
								break;
							case 67:
								score = 89;
								break;
							case 68:
								score = 91;
								break;
							case 69:
								score = 92;
								break;
							case 70:
								score = 93;
								break;
							case 71:
								score = 94;
								break;
							case 72:
								score = 95;
								break;
							case 73:
								score = 96;
								break;
							case 74:
								score = 98;
								break;
							case 75:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_37to41:
				if(situps > 20) {
					if(situps < 76) {
						switch(situps) {
							case 21:
								score = 42;
								break;
							case 22:
								score = 43;
								break;
							case 23:
								score = 44;
								break;
							case 24:
								score = 45;
								break;
							case 25:
								score = 46;
								break;
							case 26:
								score = 47;
								break;
							case 27:
								score = 48;
								break;
							case 28:
								score = 49;
								break;
							case 29:
								score = 50;
								break;
							case 30:
								score = 52;
								break;
							case 31:
								score = 53;
								break;
							case 32:
								score = 54;
								break;
							case 33:
								score = 55;
								break;
							case 34:
								score = 56;
								break;
							case 35:
								score = 57;
								break;
							case 36:
								score = 58;
								break;
							case 37:
								score = 59;
								break;
							case 38:
								score = 60;
								break;
							case 39:
								score = 61;
								break;
							case 40:
								score = 62;
								break;
							case 41:
								score = 63;
								break;
							case 42:
								score = 64;
								break;
							case 43:
								score = 65;
								break;
							case 44:
								score = 66;
								break;
							case 45:
								score = 67;
								break;
							case 46:
								score = 68;
								break;
							case 47:
								score = 69;
								break;
							case 48:
								score = 71;
								break;
							case 49:
								score = 72;
								break;
							case 50:
								score = 73;
								break;
							case 51:
								score = 74;
								break;
							case 52:
								score = 75;
								break;
							case 53:
								score = 76;
								break;
							case 54:
								score = 77;
								break;
							case 55:
								score = 78;
								break;
							case 56:
								score = 79;
								break;
							case 57:
								score = 80;
								break;
							case 58:
								score = 81;
								break;
							case 59:
								score = 82;
								break;
							case 60:
								score = 83;
								break;
							case 61:
								score = 84;
								break;
							case 62:
								score = 85;
								break;
							case 63:
								score = 86;
								break;
							case 64:
								score = 87;
								break;
							case 65:
								score = 88;
								break;
							case 66:
								score = 89;
								break;
							case 67:
								score = 91;
								break;
							case 68:
								score = 92;
								break;
							case 69:
								score = 93;
								break;
							case 70:
								score = 94;
								break;
							case 71:
								score = 95;
								break;
							case 72:
								score = 96;
								break;
							case 73:
								score = 97;
								break;
							case 74:
								score = 98;
								break;
							case 75:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_42to46:
				if(situps > 20) {
					if(situps < 72) {
						switch(situps) {
							case 21:
								score = 49;
								break;
							case 22:
								score = 50;
								break;
							case 23:
								score = 51;
								break;
							case 24:
								score = 52;
								break;
							case 25:
								score = 53;
								break;
							case 26:
								score = 54;
								break;
							case 27:
								score = 55;
								break;
							case 28:
								score = 56;
								break;
							case 29:
								score = 57;
								break;
							case 30:
								score = 58;
								break;
							case 31:
								score = 59;
								break;
							case 32:
								score = 60;
								break;
							case 33:
								score = 61;
								break;
							case 34:
								score = 62;
								break;
							case 35:
								score = 63;
								break;
							case 36:
								score = 64;
								break;
							case 37:
								score = 65;
								break;
							case 38:
								score = 66;
								break;
							case 39:
								score = 67;
								break;
							case 40:
								score = 68;
								break;
							case 41:
								score = 69;
								break;
							case 42:
								score = 70;
								break;
							case 43:
								score = 71;
								break;
							case 44:
								score = 72;
								break;
							case 45:
								score = 73;
								break;
							case 46:
								score = 74;
								break;
							case 47:
								score = 75;
								break;
							case 48:
								score = 76;
								break;
							case 49:
								score = 77;
								break;
							case 50:
								score = 78;
								break;
							case 51:
								score = 79;
								break;
							case 52:
								score = 80;
								break;
							case 53:
								score = 81;
								break;
							case 54:
								score = 82;
								break;
							case 55:
								score = 83;
								break;
							case 56:
								score = 84;
								break;
							case 57:
								score = 85;
								break;
							case 58:
								score = 86;
								break;
							case 59:
								score = 87;
								break;
							case 60:
								score = 88;
								break;
							case 61:
								score = 89;
								break;
							case 62:
								score = 90;
								break;
							case 63:
								score = 91;
								break;
							case 64:
								score = 92;
								break;
							case 65:
								score = 93;
								break;
							case 66:
								score = 94;
								break;
							case 67:
								score = 95;
								break;
							case 68:
								score = 96;
								break;
							case 69:
								score = 97;
								break;
							case 70:
								score = 98;
								break;
							case 71:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_47to51:
				if(situps > 20) {
					if(situps < 66) {
						switch(situps) {
							case 21:
								score = 50;
								break;
							case 22:
								score = 51;
								break;
							case 23:
								score = 52;
								break;
							case 24:
								score = 53;
								break;
							case 25:
								score = 54;
								break;
							case 26:
								score = 56;
								break;
							case 27:
								score = 57;
								break;
							case 28:
								score = 58;
								break;
							case 29:
								score = 59;
								break;
							case 30:
								score = 60;
								break;
							case 31:
								score = 61;
								break;
							case 32:
								score = 62;
								break;
							case 33:
								score = 63;
								break;
							case 34:
								score = 64;
								break;
							case 35:
								score = 66;
								break;
							case 36:
								score = 67;
								break;
							case 37:
								score = 68;
								break;
							case 38:
								score = 69;
								break;
							case 39:
								score = 70;
								break;
							case 40:
								score = 71;
								break;
							case 41:
								score = 72;
								break;
							case 42:
								score = 73;
								break;
							case 43:
								score = 74;
								break;
							case 44:
								score = 76;
								break;
							case 45:
								score = 77;
								break;
							case 46:
								score = 78;
								break;
							case 47:
								score = 79;
								break;
							case 48:
								score = 80;
								break;
							case 49:
								score = 81;
								break;
							case 50:
								score = 82;
								break;
							case 51:
								score = 83;
								break;
							case 52:
								score = 84;
								break;
							case 53:
								score = 86;
								break;
							case 54:
								score = 87;
								break;
							case 55:
								score = 88;
								break;
							case 56:
								score = 89;
								break;
							case 57:
								score = 90;
								break;
							case 58:
								score = 91;
								break;
							case 59:
								score = 92;
								break;
							case 60:
								score = 93;
								break;
							case 61:
								score = 94;
								break;
							case 62:
								score = 96;
								break;
							case 63:
								score = 97;
								break;
							case 64:
								score = 98;
								break;
							case 65:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_52to56:
				if(situps > 20) {
					if(situps < 66) {
						switch(situps) {
							case 21:
								score = 53;
								break;
							case 22:
								score = 54;
								break;
							case 23:
								score = 55;
								break;
							case 24:
								score = 56;
								break;
							case 25:
								score = 57;
								break;
							case 26:
								score = 58;
								break;
							case 27:
								score = 59;
								break;
							case 28:
								score = 60;
								break;
							case 29:
								score = 61;
								break;
							case 30:
								score = 62;
								break;
							case 31:
								score = 63;
								break;
							case 32:
								score = 64;
								break;
							case 33:
								score = 65;
								break;
							case 34:
								score = 66;
								break;
							case 35:
								score = 67;
								break;
							case 36:
								score = 68;
								break;
							case 37:
								score = 69;
								break;
							case 38:
								score = 71;
								break;
							case 39:
								score = 72;
								break;
							case 40:
								score = 73;
								break;
							case 41:
								score = 74;
								break;
							case 42:
								score = 75;
								break;
							case 43:
								score = 76;
								break;
							case 44:
								score = 77;
								break;
							case 45:
								score = 78;
								break;
							case 46:
								score = 79;
								break;
							case 47:
								score = 80;
								break;
							case 48:
								score = 81;
								break;
							case 49:
								score = 82;
								break;
							case 50:
								score = 83;
								break;
							case 51:
								score = 84;
								break;
							case 52:
								score = 85;
								break;
							case 53:
								score = 86;
								break;
							case 54:
								score = 87;
								break;
							case 55:
								score = 88;
								break;
							case 56:
								score = 89;
								break;
							case 57:
								score = 91;
								break;
							case 58:
								score = 92;
								break;
							case 59:
								score = 93;
								break;
							case 60:
								score = 94;
								break;
							case 61:
								score = 95;
								break;
							case 62:
								score = 96;
								break;
							case 63:
								score = 97;
								break;
							case 64:
								score = 98;
								break;
							case 65:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_57to61:
				if(situps > 20) {
					if(situps < 64) {
						switch(situps) {
							case 21:
								score = 54;
								break;
							case 22:
								score = 55;
								break;
							case 23:
								score = 56;
								break;
							case 24:
								score = 57;
								break;
							case 25:
								score = 58;
								break;
							case 26:
								score = 59;
								break;
							case 27:
								score = 60;
								break;
							case 28:
								score = 61;
								break;
							case 29:
								score = 62;
								break;
							case 30:
								score = 63;
								break;
							case 31:
								score = 64;
								break;
							case 32:
								score = 65;
								break;
							case 33:
								score = 66;
								break;
							case 34:
								score = 68;
								break;
							case 35:
								score = 69;
								break;
							case 36:
								score = 70;
								break;
							case 37:
								score = 71;
								break;
							case 38:
								score = 72;
								break;
							case 39:
								score = 73;
								break;
							case 40:
								score = 74;
								break;
							case 41:
								score = 75;
								break;
							case 42:
								score = 76;
								break;
							case 43:
								score = 77;
								break;
							case 44:
								score = 78;
								break;
							case 45:
								score = 79;
								break;
							case 46:
								score = 81;
								break;
							case 47:
								score = 82;
								break;
							case 48:
								score = 83;
								break;
							case 49:
								score = 84;
								break;
							case 50:
								score = 85;
								break;
							case 51:
								score = 86;
								break;
							case 52:
								score = 87;
								break;
							case 53:
								score = 88;
								break;
							case 54:
								score = 89;
								break;
							case 55:
								score = 90;
								break;
							case 56:
								score = 91;
								break;
							case 57:
								score = 92;
								break;
							case 58:
								score = 94;
								break;
							case 59:
								score = 95;
								break;
							case 60:
								score = 96;
								break;
							case 61:
								score = 97;
								break;
							case 62:
								score = 98;
								break;
							case 63:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_62andup:
				if(situps > 20) {
					if(situps < 63) {
						switch(situps) {
							case 21:
								score = 55;
								break;
							case 22:
								score = 56;
								break;
							case 23:
								score = 57;
								break;
							case 24:
								score = 58;
								break;
							case 25:
								score = 59;
								break;
							case 26:
								score = 60;
								break;
							case 27:
								score = 61;
								break;
							case 28:
								score = 62;
								break;
							case 29:
								score = 63;
								break;
							case 30:
								score = 64;
								break;
							case 31:
								score = 65;
								break;
							case 32:
								score = 66;
								break;
							case 33:
								score = 68;
								break;
							case 34:
								score = 69;
								break;
							case 35:
								score = 70;
								break;
							case 36:
								score = 71;
								break;
							case 37:
								score = 72;
								break;
							case 38:
								score = 73;
								break;
							case 39:
								score = 74;
								break;
							case 40:
								score = 75;
								break;
							case 41:
								score = 76;
								break;
							case 42:
								score = 77;
								break;
							case 43:
								score = 78;
								break;
							case 44:
								score = 79;
								break;
							case 45:
								score = 81;
								break;
							case 46:
								score = 82;
								break;
							case 47:
								score = 83;
								break;
							case 48:
								score = 84;
								break;
							case 49:
								score = 85;
								break;
							case 50:
								score = 86;
								break;
							case 51:
								score = 87;
								break;
							case 52:
								score = 88;
								break;
							case 53:
								score = 89;
								break;
							case 54:
								score = 90;
								break;
							case 55:
								score = 91;
								break;
							case 56:
								score = 92;
								break;
							case 57:
								score = 94;
								break;
							case 58:
								score = 95;
								break;
							case 59:
								score = 96;
								break;
							case 60:
								score = 97;
								break;
							case 61:
								score = 98;
								break;
							case 62:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
		}
		
		return score;
		
	}
	
	private int calculate_aerobic_male() {  // TODO

		int minutes = 0;
		int seconds = 0;
		int score = 0;

		try {
			minutes = Integer.parseInt( edittext_minutes.getText().toString() );
		} catch(NumberFormatException ex) {}

		try {
			seconds = Integer.parseInt( edittext_seconds.getText().toString() );
		} catch(NumberFormatException ex) {}
		
		switch(event) {
			case RUN:
				switch(age) {
					case AGE_17to21:
						if(minutes < 21) {
							if(minutes > 12) {
								switch(minutes) {
									case 13:
										if( (seconds > 0) && (seconds < 2) ) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 97;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 96;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 94;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 93;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 92;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 90;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 89;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 88;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 86;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 85;
										} else {
											score = 100;
										}
										break;
									case 14:
										if(seconds < 2) {
											score = 85;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 83;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 82;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 81;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 79;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 78;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 77;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 75;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 74;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 72;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 71;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 71;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 70;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 68;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 67;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 66;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 64;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 63;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 61;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 60;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 59;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 57;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 57;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 56;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 54;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 53;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 52;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 50;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 49;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 48;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 46;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 45;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 43;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 43;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 42;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 41;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 39;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 38;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 37;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 35;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 34;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 32;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 31;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 30;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 30;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 28;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 27;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 26;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 24;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 23;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 21;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 20;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 19;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 17;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 16;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 16;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 14;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 13;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 12;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 10;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 9;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 8;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 6;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 5;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 3;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 2;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 2;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 1;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_22to26:
						if(minutes < 22) {
							if(minutes > 12) {
								switch(minutes) {
									case 13:
										if( (seconds > 0) && (seconds < 2) ) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 98;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 97;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 96;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 94;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 93;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 92;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 91;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 90;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 89;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 88;
										} else {
											score = 100;
										}
										break;
									case 14:
										if(seconds < 2) {
											score = 88;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 87;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 86;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 84;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 83;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 82;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 81;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 80;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 79;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 78;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 77;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 77;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 76;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 74;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 73;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 72;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 71;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 70;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 69;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 68;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 67;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 66;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 66;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 64;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 62;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 61;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 60;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 59;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 58;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 57;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 56;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 54;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 54;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 53;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 52;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 51;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 50;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 49;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 48;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 47;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 46;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 44;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 43;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 43;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 42;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 41;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 40;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 39;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 38;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 37;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 36;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 34;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 33;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 32;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 32;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 31;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 30;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 29;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 28;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 27;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 26;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 24;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 23;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 22;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 21;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 21;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 20;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 19;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 18;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 17;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 16;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 14;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 13;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 12;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 11;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 10;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 10;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 9;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 8;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 7;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 6;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 4;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 3;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 2;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 1;
										}
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_27to31:
						if(minutes < 23) {
							if(minutes > 12) {
								switch(minutes) {
									case 13:
										if ( (seconds > 13) && (seconds < 20) ) {
											score = 99;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 98;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 97;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 96;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 95;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 94;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 92;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 91;
										} else {
											score = 100;
										}
										break;
									case 14:
										if(seconds < 2) {
											score = 91;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 90;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 89;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 88;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 87;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 86;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 85;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 84;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 83;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 82;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 81;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 81;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 79;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 78;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 77;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 76;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 75;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 72;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 71;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 70;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 70;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 69;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 68;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 66;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 65;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 64;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 63;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 62;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 61;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 60;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 59;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 59;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 58;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 57;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 56;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 55;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 52;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 51;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 50;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 49;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 48;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 48;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 47;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 46;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 45;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 44;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 43;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 42;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 41;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 39;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 38;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 37;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 37;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 36;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 35;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 35;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 33;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 32;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 31;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 30;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 29;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 28;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 26;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 26;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 25;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 24;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 23;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 22;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 21;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 20;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 19;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 18;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 17;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 16;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 16;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 15;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 14;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 12;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 11;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 10;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 9;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 8;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 7;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 6;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 5;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 5;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 4;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 3;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 2;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 1;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_32to36:
						if(minutes < 25) {
							if(minutes > 12) {
								switch(minutes) {
									case 13:
										if ( (seconds > 13) && (seconds < 20) ) {
											score = 99;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 98;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 97;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 96;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 95;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 95;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 94;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 93;
										} else {
											score = 100;
										}
										break;
									case 14:
										if(seconds < 2) {
											score = 93;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 92;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 91;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 89;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 88;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 87;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 86;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 85;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 85;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 84;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 84;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 83;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 82;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 81;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 80;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 79;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 78;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 77;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 76;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 75;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 75;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 75;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 74;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 73;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 72;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 71;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 70;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 69;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 68;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 65;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 65;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 65;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 64;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 63;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 62;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 61;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 60;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 59;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 58;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 57;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 56;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 56;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 55;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 55;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 54;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 53;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 52;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 51;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 50;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 49;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 48;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 47;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 47;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 46;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 45;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 45;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 44;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 43;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 42;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 41;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 40;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 39;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 38;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 38;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 37;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 36;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 35;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 35;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 34;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 33;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 32;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 31;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 30;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 29;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 29;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 28;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 27;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 26;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 25;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 25;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 24;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 23;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 22;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 21;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 20;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 20;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 19;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 18;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 17;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 16;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 15;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 15;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 14;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 13;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 12;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 11;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 11;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 10;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 9;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 8;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 7;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 6;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 5;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 5;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 4;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 3;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 2;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 2;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 1;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_37to41:
						if(minutes < 25) {
							if(minutes > 12) {
								switch(minutes) {
									case 13:
										if ( (seconds > 31) && (seconds < 38) ) {
											score = 99;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 98;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 97;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 97;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 96;
										} else {
											score = 100;
										}
										break;
									case 14:
										if(seconds < 2) {
											score = 96;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 95;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 94;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 93;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 92;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 91;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 91;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 90;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 89;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 88;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 87;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 87;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 86;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 86;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 85;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 84;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 83;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 82;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 81;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 80;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 80;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 79;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 79;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 78;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 77;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 76;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 75;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 74;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 72;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 71;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 70;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 70;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 69;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 69;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 68;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 67;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 66;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 65;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 64;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 63;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 63;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 62;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 62;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 61;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 60;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 59;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 58;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 57;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 57;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 56;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 55;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 54;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 53;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 53;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 52;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 51;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 51;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 50;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 49;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 48;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 47;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 46;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 46;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 45;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 45;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 44;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 43;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 42;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 41;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 40;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 40;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 39;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 38;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 37;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 36;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 36;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 35;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 34;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 34;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 33;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 32;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 31;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 30;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 29;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 29;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 28;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 28;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 27;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 26;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 25;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 24;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 23;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 23;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 22;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 21;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 20;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 19;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 19;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 18;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 17;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 17;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 16;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 15;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 14;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 13;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 12;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 11;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 11;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 11;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 10;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 9;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 8;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 7;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 6;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 6;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 5;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 4;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 3;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_42to46:
						if(minutes < 25) {
							if(minutes > 13) {
								switch(minutes) {
									case 14:
										if ( (seconds > 1) && (seconds < 8) ) {
											score = 99;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 98;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 97;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 97;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 96;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 95;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 94;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 93;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 92;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 91;
										} else {
											score = 100;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 91;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 90;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 90;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 89;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 88;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 87;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 86;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 85;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 84;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 83;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 83;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 83;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 82;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 81;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 80;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 79;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 78;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 77;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 77;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 76;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 75;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 74;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 74;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 73;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 72;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 71;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 70;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 70;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 69;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 68;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 65;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 65;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 64;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 63;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 62;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 61;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 60;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 59;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 58;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 57;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 57;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 57;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 56;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 55;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 54;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 53;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 52;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 51;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 50;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 50;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 49;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 48;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 48;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 47;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 46;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 45;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 44;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 43;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 43;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 42;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 41;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 40;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 39;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 39;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 38;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 37;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 37;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 36;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 35;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 34;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 33;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 32;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 31;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 30;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 30;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 30;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 29;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 28;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 27;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 26;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 25;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 24;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 23;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 23;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 22;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 22;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 21;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 20;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 19;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 18;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 17;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 17;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 16;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 15;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 14;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 13;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 13;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 12;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 11;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 10;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 10;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 9;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 8;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 7;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 6;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 5;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_47to51:
						if(minutes < 25) {
							if(minutes > 13) {
								switch(minutes) {
									case 14:
										if ( (seconds > 19) && (seconds < 26) ) {
											score = 99;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 98;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 98;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 97;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 96;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 95;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 95;
										} else {
											score = 100;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 95;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 94;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 93;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 92;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 91;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 91;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 90;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 89;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 88;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 87;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 87;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 87;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 86;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 85;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 84;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 84;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 83;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 82;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 81;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 80;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 80;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 79;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 79;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 78;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 77;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 76;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 76;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 75;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 73;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 72;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 71;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 71;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 70;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 69;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 69;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 68;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 67;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 66;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 65;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 65;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 64;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 63;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 63;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 62;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 62;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 61;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 60;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 59;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 58;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 58;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 57;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 56;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 55;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 55;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 55;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 54;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 53;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 52;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 51;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 51;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 50;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 49;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 48;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 47;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 47;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 47;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 46;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 45;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 44;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 44;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 43;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 42;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 41;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 40;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 40;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 40;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 39;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 38;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 37;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 36;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 36;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 35;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 34;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 33;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 33;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 32;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 32;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 31;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 30;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 29;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 29;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 28;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 27;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 26;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 25;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 25;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 24;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 24;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 23;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 22;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 22;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 21;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 20;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 19;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 18;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 18;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 17;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_52to56:
						if(minutes < 25) {
							if(minutes > 13) {
								switch(minutes) {
									case 14:
										if ( (seconds > 37) && (seconds < 44) ) {
											score = 99;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 98;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 98;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 97;
										} else {
											score = 100;
										}
										break;
									case 15:
										if(seconds < 2) {
											score = 97;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 96;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 95;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 95;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 94;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 93;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 92;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 91;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 91;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 90;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 89;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 89;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 88;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 87;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 87;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 86;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 85;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 84;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 84;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 83;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 82;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 81;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 81;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 80;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 80;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 79;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 78;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 77;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 76;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 76;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 75;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 74;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 73;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 73;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 73;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 72;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 71;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 70;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 69;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 69;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 68;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 65;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 65;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 65;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 64;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 63;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 62;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 62;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 61;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 60;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 59;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 58;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 58;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 58;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 57;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 56;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 55;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 55;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 53;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 52;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 51;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 51;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 50;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 50;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 49;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 48;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 47;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 47;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 46;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 45;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 44;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 44;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 43;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 42;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 42;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 41;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 40;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 40;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 39;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 38;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 37;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 36;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 36;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 35;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 34;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 34;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 33;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 33;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 32;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 31;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 30;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 29;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 29;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 28;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 27;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 26;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 26;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 25;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 25;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 24;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 23;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 22;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 22;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 21;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 20;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 19;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_57to61:
						if(minutes < 25) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 13) && (seconds < 20) ) {
											score = 99;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 98;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 97;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 97;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 96;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 95;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 94;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 93;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 93;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 92;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 91;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 90;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 89;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 88;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 87;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 86;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 85;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 84;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 84;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 83;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 83;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 82;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 81;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 80;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 79;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 78;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 77;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 77;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 76;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 76;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 75;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 74;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 73;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 72;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 71;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 70;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 70;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 69;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 68;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 67;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 67;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 66;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 65;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 64;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 63;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 63;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 62;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 61;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 60;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 59;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 58;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 58;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 57;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 57;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 56;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 55;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 53;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 52;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 51;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 50;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 50;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 50;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 49;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 48;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 47;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 46;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 45;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 44;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 43;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 43;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 42;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 41;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 41;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 40;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 39;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 38;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 37;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 37;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 36;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 35;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 34;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 33;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 32;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 32;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 31;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 30;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 30;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 29;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 28;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 27;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 26;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 25;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 24;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 23;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 23;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 23;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 22;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 21;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 20;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 19;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 18;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 17;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 17;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 16;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_62andup:
						if(minutes < 25) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 37) && (seconds < 44) ) {
											score = 99;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 98;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 97;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 96;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 96;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 95;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 94;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 93;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 93;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 92;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 91;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 90;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 89;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 88;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 87;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 87;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 86;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 85;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 84;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 83;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 82;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 81;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 80;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 80;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 79;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 78;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 78;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 77;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 76;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 75;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 74;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 73;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 72;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 71;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 70;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 69;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 68;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 68;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 67;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 67;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 66;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 65;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 64;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 63;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 62;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 61;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 60;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 59;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 59;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 58;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 57;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 56;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 55;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 53;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 53;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 52;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 51;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 50;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 50;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 49;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 48;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 47;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 46;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 45;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 44;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 43;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 42;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 41;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 40;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 40;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 40;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 39;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 38;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 37;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 36;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 35;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 34;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 33;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 32;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 31;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 31;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 30;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 29;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 28;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 27;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 27;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 26;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 25;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 24;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 23;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 22;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 22;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 21;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 20;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 19;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 18;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 17;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 16;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 15;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 14;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 13;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
				}
				break;
			case SWIM:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 20) ) {
							score = 60;
						} else {
							if(minutes == 20) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 20) ) {
							score = 60;
						} else {
							if(minutes == 20) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 21) ) {
							score = 60;
						} else {
							if(minutes == 21) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 21) ) {
							score = 60;
						} else {
							if(minutes == 21) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 22) ) {
							score = 60;
						} else {
							if(minutes == 22) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 22) ) {
							score = 60;
						} else {
							if(minutes == 22) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 23) ) {
							score = 60;
						} else {
							if(minutes == 23) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 24) ) {
							score = 60;
						} else {
							if(minutes == 24) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 24) ) {
							score = 60;
						} else {
							if(minutes == 24) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
			case BICYCLE:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 24) ) {
							score = 60;
						} else {
							if(minutes == 24) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 24) ) {
							score = 60;
						} else {
							if(minutes == 24) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 26) ) {
							score = 60;
						} else {
							if(minutes == 26) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 27) ) {
							score = 60;
						} else {
							if(minutes == 27) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 28) ) {
							score = 60;
						} else {
							if(minutes == 28) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 30) ) {
							score = 60;
						} else {
							if(minutes == 30) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 31) ) {
							score = 60;
						} else {
							if(minutes == 31) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 32) ) {
							score = 60;
						} else {
							if(minutes == 32) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
			case WALK:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 34) ) {
							score = 60;
						} else {
							if(minutes == 34) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 34) ) {
							score = 60;
						} else {
							if(minutes == 34) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 35) ) {
							score = 60;
						} else {
							if(minutes == 35) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 35) ) {
							score = 60;
						} else {
							if(minutes == 35) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 36) ) {
							score = 60;
						} else {
							if(minutes == 36) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 36) ) {
							score = 60;
						} else {
							if(minutes == 36) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 37) ) {
							score = 60;
						} else {
							if(minutes == 37) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 37) ) {
							score = 60;
						} else {
							if(minutes == 37) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 38) ) {
							score = 60;
						} else {
							if(minutes == 38) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 38) ) {
							score = 60;
						} else {
							if(minutes == 38) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
		}
		
		return score;
		
	}
	
	private int calculate_pushups_female() {  // TODO

		int pushups = 0;
		int score = 0;
		
		try {
			pushups = Integer.parseInt( edittext_pushups.getText().toString() );
		} catch(NumberFormatException ex) {}
		
		switch(age) {
			case AGE_17to21:
				if(pushups > 4) {
					if(pushups < 42) {
						switch(pushups) {
							case 5:
								score = 36;
								break;
							case 6:
								score = 37;
								break;
							case 7:
								score = 39;
								break;
							case 8:
								score = 41;
								break;
							case 9:
								score = 43;
								break;
							case 10:
								score = 44;
								break;
							case 11:
								score = 46;
								break;
							case 12:
								score = 48;
								break;
							case 13:
								score = 50;
								break;
							case 14:
								score = 51;
								break;
							case 15:
								score = 53;
								break;
							case 16:
								score = 55;
								break;
							case 17:
								score = 57;
								break;
							case 18:
								score = 58;
								break;
							case 19:
								score = 60;
								break;
							case 20:
								score = 62;
								break;
							case 21:
								score = 63;
								break;
							case 22:
								score = 65;
								break;
							case 23:
								score = 67;
								break;
							case 24:
								score = 69;
								break;
							case 25:
								score = 70;
								break;
							case 26:
								score = 72;
								break;
							case 27:
								score = 74;
								break;
							case 28:
								score = 76;
								break;
							case 29:
								score = 77;
								break;
							case 30:
								score = 79;
								break;
							case 31:
								score = 81;
								break;
							case 32:
								score = 83;
								break;
							case 33:
								score = 84;
								break;
							case 34:
								score = 86;
								break;
							case 35:
								score = 88;
								break;
							case 36:
								score = 90;
								break;
							case 37:
								score = 91;
								break;
							case 38:
								score = 93;
								break;
							case 39:
								score = 95;
								break;
							case 40:
								score = 97;
								break;
							case 41:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_22to26:
				if(pushups > 4) {
					if(pushups < 46) {
						switch(pushups) {
							case 5:
								score = 43;
								break;
							case 6:
								score = 45;
								break;
							case 7:
								score = 46;
								break;
							case 8:
								score = 48;
								break;
							case 9:
								score = 49;
								break;
							case 10:
								score = 49;
								break;
							case 11:
								score = 50;
								break;
							case 12:
								score = 52;
								break;
							case 13:
								score = 54;
								break;
							case 14:
								score = 56;
								break;
							case 15:
								score = 57;
								break;
							case 16:
								score = 59;
								break;
							case 17:
								score = 60;
								break;
							case 18:
								score = 61;
								break;
							case 19:
								score = 63;
								break;
							case 20:
								score = 64;
								break;
							case 21:
								score = 66;
								break;
							case 22:
								score = 67;
								break;
							case 23:
								score = 68;
								break;
							case 24:
								score = 70;
								break;
							case 25:
								score = 71;
								break;
							case 26:
								score = 72;
								break;
							case 27:
								score = 74;
								break;
							case 28:
								score = 75;
								break;
							case 29:
								score = 77;
								break;
							case 30:
								score = 78;
								break;
							case 31:
								score = 79;
								break;
							case 32:
								score = 81;
								break;
							case 33:
								score = 82;
								break;
							case 34:
								score = 83;
								break;
							case 35:
								score = 85;
								break;
							case 36:
								score = 86;
								break;
							case 37:
								score = 88;
								break;
							case 38:
								score = 89;
								break;
							case 39:
								score = 90;
								break;
							case 40:
								score = 92;
								break;
							case 41:
								score = 93;
								break;
							case 42:
								score = 94;
								break;
							case 43:
								score = 96;
								break;
							case 44:
								score = 97;
								break;
							case 45:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_27to31:
				if(pushups > 4) {
					if(pushups < 50) {
						switch(pushups) {
							case 5:
								score = 45;
								break;
							case 6:
								score = 47;
								break;
							case 7:
								score = 48;
								break;
							case 8:
								score = 49;
								break;
							case 9:
								score = 49;
								break;
							case 10:
								score = 50;
								break;
							case 11:
								score = 52;
								break;
							case 12:
								score = 54;
								break;
							case 13:
								score = 55;
								break;
							case 14:
								score = 56;
								break;
							case 15:
								score = 58;
								break;
							case 16:
								score = 59;
								break;
							case 17:
								score = 60;
								break;
							case 18:
								score = 61;
								break;
							case 19:
								score = 62;
								break;
							case 20:
								score = 64;
								break;
							case 21:
								score = 65;
								break;
							case 22:
								score = 66;
								break;
							case 23:
								score = 67;
								break;
							case 24:
								score = 68;
								break;
							case 25:
								score = 70;
								break;
							case 26:
								score = 71;
								break;
							case 27:
								score = 72;
								break;
							case 28:
								score = 73;
								break;
							case 29:
								score = 75;
								break;
							case 30:
								score = 76;
								break;
							case 31:
								score = 77;
								break;
							case 32:
								score = 78;
								break;
							case 33:
								score = 79;
								break;
							case 34:
								score = 81;
								break;
							case 35:
								score = 82;
								break;
							case 36:
								score = 83;
								break;
							case 37:
								score = 84;
								break;
							case 38:
								score = 85;
								break;
							case 39:
								score = 87;
								break;
							case 40:
								score = 88;
								break;
							case 41:
								score = 89;
								break;
							case 42:
								score = 90;
								break;
							case 43:
								score = 92;
								break;
							case 44:
								score = 93;
								break;
							case 45:
								score = 94;
								break;
							case 46:
								score = 95;
								break;
							case 47:
								score = 96;
								break;
							case 48:
								score = 98;
								break;
							case 49:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_32to36:
				if(pushups > 4) {
					if(pushups < 45) {
						switch(pushups) {
							case 5:
								score = 47;
								break;
							case 6:
								score = 48;
								break;
							case 7:
								score = 49;
								break;
							case 8:
								score = 49;
								break;
							case 9:
								score = 50;
								break;
							case 10:
								score = 52;
								break;
							case 11:
								score = 54;
								break;
							case 12:
								score = 56;
								break;
							case 13:
								score = 58;
								break;
							case 14:
								score = 59;
								break;
							case 15:
								score = 60;
								break;
							case 16:
								score = 61;
								break;
							case 17:
								score = 63;
								break;
							case 18:
								score = 64;
								break;
							case 19:
								score = 65;
								break;
							case 20:
								score = 67;
								break;
							case 21:
								score = 68;
								break;
							case 22:
								score = 69;
								break;
							case 23:
								score = 71;
								break;
							case 24:
								score = 72;
								break;
							case 25:
								score = 73;
								break;
							case 26:
								score = 75;
								break;
							case 27:
								score = 76;
								break;
							case 28:
								score = 77;
								break;
							case 29:
								score = 79;
								break;
							case 30:
								score = 80;
								break;
							case 31:
								score = 81;
								break;
							case 32:
								score = 83;
								break;
							case 33:
								score = 84;
								break;
							case 34:
								score = 85;
								break;
							case 35:
								score = 87;
								break;
							case 36:
								score = 88;
								break;
							case 37:
								score = 89;
								break;
							case 38:
								score = 91;
								break;
							case 39:
								score = 92;
								break;
							case 40:
								score = 93;
								break;
							case 41:
								score = 95;
								break;
							case 42:
								score = 96;
								break;
							case 43:
								score = 97;
								break;
							case 44:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_37to41:
				if(pushups > 4) {
					if(pushups < 40) {
						switch(pushups) {
							case 5:
								score = 48;
								break;
							case 6:
								score = 50;
								break;
							case 7:
								score = 51;
								break;
							case 8:
								score = 53;
								break;
							case 9:
								score = 54;
								break;
							case 10:
								score = 56;
								break;
							case 11:
								score = 57;
								break;
							case 12:
								score = 59;
								break;
							case 13:
								score = 60;
								break;
							case 14:
								score = 61;
								break;
							case 15:
								score = 63;
								break;
							case 16:
								score = 64;
								break;
							case 17:
								score = 66;
								break;
							case 18:
								score = 67;
								break;
							case 19:
								score = 69;
								break;
							case 20:
								score = 70;
								break;
							case 21:
								score = 72;
								break;
							case 22:
								score = 73;
								break;
							case 23:
								score = 75;
								break;
							case 24:
								score = 76;
								break;
							case 25:
								score = 78;
								break;
							case 26:
								score = 79;
								break;
							case 27:
								score = 81;
								break;
							case 28:
								score = 82;
								break;
							case 29:
								score = 84;
								break;
							case 30:
								score = 85;
								break;
							case 31:
								score = 87;
								break;
							case 32:
								score = 88;
								break;
							case 33:
								score = 90;
								break;
							case 34:
								score = 91;
								break;
							case 35:
								score = 93;
								break;
							case 36:
								score = 94;
								break;
							case 37:
								score = 96;
								break;
							case 38:
								score = 97;
								break;
							case 39:
								score = 99;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_42to46:
				if(pushups > 4) {
					if(pushups < 37) {
						switch(pushups) {
							case 5:
								score = 49;
								break;
							case 6:
								score = 50;
								break;
							case 7:
								score = 52;
								break;
							case 8:
								score = 54;
								break;
							case 9:
								score = 55;
								break;
							case 10:
								score = 57;
								break;
							case 11:
								score = 58;
								break;
							case 12:
								score = 60;
								break;
							case 13:
								score = 62;
								break;
							case 14:
								score = 63;
								break;
							case 15:
								score = 65;
								break;
							case 16:
								score = 66;
								break;
							case 17:
								score = 68;
								break;
							case 18:
								score = 70;
								break;
							case 19:
								score = 71;
								break;
							case 20:
								score = 73;
								break;
							case 21:
								score = 74;
								break;
							case 22:
								score = 76;
								break;
							case 23:
								score = 78;
								break;
							case 24:
								score = 79;
								break;
							case 25:
								score = 81;
								break;
							case 26:
								score = 82;
								break;
							case 27:
								score = 84;
								break;
							case 28:
								score = 86;
								break;
							case 29:
								score = 87;
								break;
							case 30:
								score = 89;
								break;
							case 31:
								score = 90;
								break;
							case 32:
								score = 92;
								break;
							case 33:
								score = 94;
								break;
							case 34:
								score = 95;
								break;
							case 35:
								score = 97;
								break;
							case 36:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_47to51:
				if(pushups > 4) {
					if(pushups < 34) {
						switch(pushups) {
							case 5:
								score = 52;
								break;
							case 6:
								score = 53;
								break;
							case 7:
								score = 55;
								break;
							case 8:
								score = 57;
								break;
							case 9:
								score = 58;
								break;
							case 10:
								score = 60;
								break;
							case 11:
								score = 62;
								break;
							case 12:
								score = 63;
								break;
							case 13:
								score = 65;
								break;
							case 14:
								score = 67;
								break;
							case 15:
								score = 68;
								break;
							case 16:
								score = 70;
								break;
							case 17:
								score = 72;
								break;
							case 18:
								score = 73;
								break;
							case 19:
								score = 75;
								break;
							case 20:
								score = 77;
								break;
							case 21:
								score = 78;
								break;
							case 22:
								score = 80;
								break;
							case 23:
								score = 82;
								break;
							case 24:
								score = 83;
								break;
							case 25:
								score = 85;
								break;
							case 26:
								score = 87;
								break;
							case 27:
								score = 88;
								break;
							case 28:
								score = 90;
								break;
							case 29:
								score = 92;
								break;
							case 30:
								score = 93;
								break;
							case 31:
								score = 95;
								break;
							case 32:
								score = 97;
								break;
							case 33:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_52to56:
				if(pushups > 4) {
					if(pushups < 31) {
						switch(pushups) {
							case 5:
								score = 53;
								break;
							case 6:
								score = 55;
								break;
							case 7:
								score = 56;
								break;
							case 8:
								score = 58;
								break;
							case 9:
								score = 60;
								break;
							case 10:
								score = 62;
								break;
							case 11:
								score = 64;
								break;
							case 12:
								score = 65;
								break;
							case 13:
								score = 67;
								break;
							case 14:
								score = 69;
								break;
							case 15:
								score = 71;
								break;
							case 16:
								score = 73;
								break;
							case 17:
								score = 75;
								break;
							case 18:
								score = 76;
								break;
							case 19:
								score = 78;
								break;
							case 20:
								score = 80;
								break;
							case 21:
								score = 82;
								break;
							case 22:
								score = 84;
								break;
							case 23:
								score = 85;
								break;
							case 24:
								score = 87;
								break;
							case 25:
								score = 89;
								break;
							case 26:
								score = 91;
								break;
							case 27:
								score = 93;
								break;
							case 28:
								score = 95;
								break;
							case 29:
								score = 96;
								break;
							case 30:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_57to61:
				if(pushups > 4) {
					if(pushups < 28) {
						switch(pushups) {
							case 5:
								score = 54;
								break;
							case 6:
								score = 56;
								break;
							case 7:
								score = 58;
								break;
							case 8:
								score = 60;
								break;
							case 9:
								score = 62;
								break;
							case 10:
								score = 64;
								break;
							case 11:
								score = 66;
								break;
							case 12:
								score = 68;
								break;
							case 13:
								score = 70;
								break;
							case 14:
								score = 72;
								break;
							case 15:
								score = 74;
								break;
							case 16:
								score = 76;
								break;
							case 17:
								score = 78;
								break;
							case 18:
								score = 80;
								break;
							case 19:
								score = 82;
								break;
							case 20:
								score = 84;
								break;
							case 21:
								score = 86;
								break;
							case 22:
								score = 88;
								break;
							case 23:
								score = 90;
								break;
							case 24:
								score = 92;
								break;
							case 25:
								score = 94;
								break;
							case 26:
								score = 96;
								break;
							case 27:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
			case AGE_62andup:
				if(pushups > 4) {
					if(pushups < 25) {
						switch(pushups) {
							case 5:
								score = 56;
								break;
							case 6:
								score = 58;
								break;
							case 7:
								score = 60;
								break;
							case 8:
								score = 62;
								break;
							case 9:
								score = 64;
								break;
							case 10:
								score = 67;
								break;
							case 11:
								score = 69;
								break;
							case 12:
								score = 71;
								break;
							case 13:
								score = 73;
								break;
							case 14:
								score = 76;
								break;
							case 15:
								score = 78;
								break;
							case 16:
								score = 80;
								break;
							case 17:
								score = 82;
								break;
							case 18:
								score = 84;
								break;
							case 19:
								score = 87;
								break;
							case 20:
								score = 89;
								break;
							case 21:
								score = 91;
								break;
							case 22:
								score = 93;
								break;
							case 23:
								score = 96;
								break;
							case 24:
								score = 98;
								break;
						}
					} else {
						score = 100;
					}
				}
				break;
		}
		
		return score;

	}
	
	private int calculate_aerobic_female() {  // TODO

		int minutes = 0;
		int seconds = 0;
		int score = 0;

		try {
			minutes = Integer.parseInt( edittext_minutes.getText().toString() );
		} catch(NumberFormatException ex) {}

		try {
			seconds = Integer.parseInt( edittext_seconds.getText().toString() );
		} catch(NumberFormatException ex) {}
		
		switch(event) {
			case RUN:
				switch(age) {
					case AGE_17to21:
						if(minutes < 24) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 31) && (seconds < 38) ) {
											score = 99;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 98;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 96;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 95;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 94;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 94;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 93;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 92;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 89;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 88;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 87;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 85;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 84;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 83;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 82;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 82;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 81;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 79;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 78;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 77;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 76;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 75;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 72;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 71;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 70;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 70;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 68;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 67;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 66;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 65;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 64;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 62;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 61;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 60;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 59;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 58;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 58;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 56;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 55;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 54;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 53;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 52;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 50;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 49;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 48;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 47;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 45;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 45;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 44;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 43;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 42;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 41;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 39;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 38;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 37;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 36;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 35;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 33;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 33;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 32;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 31;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 30;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 28;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 27;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 26;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 25;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 24;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 22;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 21;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 21;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 20;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 19;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 18;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 16;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 15;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 14;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 13;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 12;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 10;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 9;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 9;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 8;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 7;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 5;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 4;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 3;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 2;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 1;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_22to26:
						if(minutes < 25) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 31) && (seconds < 38) ) {
											score = 99;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 98;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 97;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 96;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 95;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 95;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 94;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 93;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 92;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 91;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 90;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 89;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 88;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 87;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 86;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 85;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 85;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 84;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 83;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 82;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 81;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 80;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 79;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 78;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 77;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 76;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 75;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 75;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 74;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 73;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 72;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 71;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 70;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 69;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 68;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 65;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 65;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 64;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 62;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 61;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 60;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 59;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 58;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 57;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 56;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 55;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 55;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 54;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 53;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 52;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 51;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 50;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 49;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 48;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 47;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 46;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 45;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 45;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 44;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 43;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 42;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 41;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 40;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 39;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 38;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 37;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 36;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 35;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 35;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 34;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 33;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 32;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 31;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 30;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 29;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 28;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 27;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 26;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 25;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 25;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 24;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 23;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 22;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 21;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 20;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 19;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 18;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 17;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 16;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 15;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 15;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 14;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 13;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 12;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 11;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 10;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 9;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 8;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 7;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 6;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_27to31:
						if(minutes < 25) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 43) && (seconds < 50) ) {
											score = 99;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 98;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 97;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 97;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 97;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 96;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 95;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 94;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 93;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 92;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 91;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 91;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 90;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 89;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 89;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 88;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 87;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 86;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 86;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 85;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 84;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 83;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 82;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 81;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 80;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 80;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 80;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 79;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 78;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 77;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 76;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 75;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 74;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 74;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 73;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 72;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 72;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 71;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 70;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 69;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 69;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 68;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 67;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 66;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 65;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 64;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 63;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 63;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 63;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 62;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 61;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 60;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 59;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 58;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 57;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 57;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 56;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 55;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 55;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 54;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 53;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 52;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 51;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 51;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 50;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 49;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 48;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 47;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 46;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 46;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 46;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 45;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 44;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 43;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 42;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 41;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 40;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 40;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 39;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 38;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 38;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 37;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 36;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 35;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 34;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 34;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 33;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 32;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 31;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 30;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 29;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 29;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 29;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 28;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 27;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 26;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 25;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 24;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 23;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 23;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 22;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_32to36:
						if(minutes < 25) {
							if(minutes > 14) {
								switch(minutes) {
									case 15:
										if ( (seconds > 49) && (seconds < 56) ) {
											score = 99;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 99;
										} else {
											score = 100;
										}
										break;
									case 16:
										if(seconds < 2) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 98;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 97;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 97;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 96;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 95;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 94;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 94;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 93;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 92;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 92;
										}
										break;
									case 17:
										if(seconds < 2) {
											score = 92;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 91;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 90;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 89;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 88;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 88;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 87;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 86;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 86;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 85;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 85;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 84;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 83;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 83;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 82;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 81;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 81;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 80;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 79;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 79;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 78;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 78;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 77;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 77;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 76;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 75;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 74;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 72;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 72;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 71;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 71;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 70;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 70;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 69;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 68;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 68;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 67;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 66;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 66;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 65;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 64;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 64;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 63;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 62;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 61;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 61;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 60;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 59;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 59;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 58;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 57;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 57;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 57;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 56;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 55;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 54;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 53;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 52;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 52;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 51;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 50;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 50;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 49;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 49;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 48;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 48;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 47;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 46;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 46;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 45;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 44;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 43;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 43;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 43;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 42;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 41;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 41;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 40;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 39;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 39;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 38;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 37;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_37to41:
						if(minutes < 25) {
							if(minutes > 15) {
								switch(minutes) {
									case 16:
										if ( (seconds > 55) && (seconds < 60) ) {
											score = 99;
										} else {
											score = 100;
										}
										 break;
									case 17:
										if(seconds < 2) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 99;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 98;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 97;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 96;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 96;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 95;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 94;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 94;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 93;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 92;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 92;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 92;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 91;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 89;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 89;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 88;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 87;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 87;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 86;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 85;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 85;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 85;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 84;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 83;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 82;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 82;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 81;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 80;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 80;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 79;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 78;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 78;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 78;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 77;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 76;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 75;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 75;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 73;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 73;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 72;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 71;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 71;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 71;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 70;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 69;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 68;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 68;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 67;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 66;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 66;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 65;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 64;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 64;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 64;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 62;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 61;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 61;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 60;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 59;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 59;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 58;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 57;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 57;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 56;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 56;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 55;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 54;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 53;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 52;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 52;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 51;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 50;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 50;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 49;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 49;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 48;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 47;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 47;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 46;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 45;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 45;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 44;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_42to46:
						if(minutes < 25) {
							if(minutes > 16) {
								switch(minutes) {
									case 17:
										if ( (seconds > 19) && (seconds < 26) ) {
											score = 99;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 99;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 98;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 97;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 97;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 96;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 96;
										}
										 else {
											score = 100;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 96;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 95;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 94;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 94;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 93;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 92;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 92;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 91;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 90;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 90;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 89;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 89;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 89;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 88;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 87;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 87;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 86;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 85;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 85;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 84;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 83;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 83;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 83;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 82;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 82;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 81;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 80;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 80;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 79;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 78;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 78;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 77;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 77;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 77;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 76;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 75;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 75;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 74;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 73;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 73;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 72;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 71;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 71;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 70;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 70;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 70;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 69;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 68;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 68;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 67;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 66;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 66;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 65;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 64;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 64;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 64;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 63;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 63;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 62;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 61;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 61;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 60;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 59;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 59;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 58;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 57;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 57;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 57;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 56;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 56;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 55;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 54;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 54;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 53;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 52;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 52;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_47to51:
						if(minutes < 25) {
							if(minutes > 16) {
								switch(minutes) {
									case 17:
										if ( (seconds > 31) && (seconds < 38) ) {
											score = 99;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 99;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 98;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 97;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 97;
										} else {
											score = 100;
										}
										break;
									case 18:
										if(seconds < 2) {
											score = 97;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 96;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 96;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 95;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 94;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 94;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 93;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 92;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 92;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 91;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 91;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 91;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 90;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 89;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 89;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 88;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 87;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 87;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 86;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 86;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 85;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 84;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 84;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 84;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 83;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 82;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 82;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 81;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 81;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 80;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 79;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 79;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 78;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 78;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 77;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 77;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 76;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 76;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 75;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 74;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 74;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 73;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 72;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 72;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 72;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 71;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 71;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 70;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 69;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 69;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 68;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 67;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 66;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 66;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 65;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 64;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 64;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 63;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 62;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 62;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 61;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 61;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 60;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 59;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 59;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 59;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 58;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 57;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 57;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 56;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 56;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 55;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 54;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 54;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_52to56:
						if(minutes < 25) {
							if(minutes > 17) {
								switch(minutes) {
									case 18:
										if ( (seconds > 55) && (seconds < 60) ) {
											score = 99;
										} else {
											score = 100;
										}
										break;
									case 19:
										if(seconds < 2) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 99;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 98;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 97;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 96;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 96;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 95;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 94;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 93;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 93;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 92;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 92;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 91;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 90;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 90;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 89;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 88;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 87;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 87;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 86;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 85;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 85;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 84;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 84;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 83;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 82;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 81;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 81;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 80;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 79;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 79;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 78;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 77;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 77;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 76;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 76;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 75;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 74;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 73;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 73;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 72;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 71;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 70;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 70;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 70;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 69;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 68;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 67;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 67;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 66;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 65;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 64;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 64;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 63;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 62;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 62;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 61;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 61;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 60;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 59;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 59;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 58;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 57;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 56;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 56;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_57to61:
						if(minutes < 25) {
							if(minutes > 18) {
								switch(minutes) {
									case 19:
										if ( (seconds > 37) && (seconds < 44) ) {
											score = 99;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 98;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 98;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 97;
										} else {
											score = 100;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 97;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 96;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 95;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 95;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 94;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 93;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 92;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 91;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 91;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 90;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 89;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 89;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 88;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 87;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 87;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 86;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 85;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 84;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 84;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 83;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 82;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 81;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 81;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 80;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 80;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 79;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 78;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 77;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 76;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 76;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 75;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 74;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 73;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 73;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 73;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 72;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 71;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 70;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 69;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 69;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 68;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 67;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 66;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 65;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 65;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 65;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 64;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 63;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 62;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 62;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 61;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 60;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 59;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 58;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
					case AGE_62andup:
						if(minutes < 25) {
							if(minutes > 18) {
								switch(minutes) {
									case 19:
										if ( (seconds > 55) && (seconds < 60) ) {
											score = 99;
										} else {
											score = 100;
										}
										break;
									case 20:
										if(seconds < 2) {
											score = 99;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 98;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 98;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 97;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 96;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 95;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 94;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 94;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 93;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 92;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 91;
										}
										break;
									case 21:
										if(seconds < 2) {
											score = 91;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 90;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 90;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 89;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 88;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 87;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 86;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 86;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 85;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 84;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 83;
										}
										break;
									case 22:
										if(seconds < 2) {
											score = 83;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 82;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 82;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 81;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 80;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 79;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 78;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 78;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 77;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 76;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 75;
										}
										break;
									case 23:
										if(seconds < 2) {
											score = 75;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 74;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 74;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 73;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 72;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 71;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 70;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 70;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 69;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 68;
										} else if ( (seconds > 55) && (seconds < 60) ) {
											score = 67;
										}
										break;
									case 24:
										if(seconds < 2) {
											score = 67;
										} else if ( (seconds > 1) && (seconds < 8) ) {
											score = 66;
										} else if ( (seconds > 7) && (seconds < 14) ) {
											score = 66;
										} else if ( (seconds > 13) && (seconds < 20) ) {
											score = 65;
										} else if ( (seconds > 19) && (seconds < 26) ) {
											score = 64;
										} else if ( (seconds > 25) && (seconds < 32) ) {
											score = 63;
										} else if ( (seconds > 31) && (seconds < 38) ) {
											score = 62;
										} else if ( (seconds > 37) && (seconds < 44) ) {
											score = 62;
										} else if ( (seconds > 43) && (seconds < 50) ) {
											score = 61;
										} else if ( (seconds > 49) && (seconds < 56) ) {
											score = 60;
										}
										break;
								}
							} else {
								if(minutes > 5) {
									score = 100;
								}
							}
						}
						break;
				}
				break;
			case SWIM:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 21) ) {
							score = 60;
						} else {
							if(minutes == 21) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 21) ) {
							score = 60;
						} else {
							if(minutes == 21) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 22) ) {
							score = 60;
						} else {
							if(minutes == 22) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 22) ) {
							score = 60;
						} else {
							if(minutes == 22) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 23) ) {
							score = 60;
						} else {
							if(minutes == 23) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 23) ) {
							score = 60;
						} else {
							if(minutes == 23) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 24) ) {
							score = 60;
						} else {
							if(minutes == 24) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 26) ) {
							score = 60;
						} else {
							if(minutes == 26) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
			case BICYCLE:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 25) ) {
							score = 60;
						} else {
							if(minutes == 25) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 26) ) {
							score = 60;
						} else {
							if(minutes == 26) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 26) ) {
							score = 60;
						} else {
							if(minutes == 26) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 27) ) {
							score = 60;
						} else {
							if(minutes == 27) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 28) ) {
							score = 60;
						} else {
							if(minutes == 28) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 30) ) {
							score = 60;
						} else {
							if(minutes == 30) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 32) ) {
							score = 60;
						} else {
							if(minutes == 32) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 33) ) {
							score = 60;
						} else {
							if(minutes == 33) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 34) ) {
							score = 60;
						} else {
							if(minutes == 34) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
			case WALK:
				switch(age) {
					case AGE_17to21:
						if( (minutes > 5) && (minutes < 37) ) {
							score = 60;
						} else {
							if(minutes == 37) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_22to26:
						if( (minutes > 5) && (minutes < 37) ) {
							score = 60;
						} else {
							if(minutes == 37) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_27to31:
						if( (minutes > 5) && (minutes < 38) ) {
							score = 60;
						} else {
							if(minutes == 38) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_32to36:
						if( (minutes > 5) && (minutes < 38) ) {
							score = 60;
						} else {
							if(minutes == 38) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_37to41:
						if( (minutes > 5) && (minutes < 39) ) {
							score = 60;
						} else {
							if(minutes == 39) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_42to46:
						if( (minutes > 5) && (minutes < 39) ) {
							score = 60;
						} else {
							if(minutes == 39) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_47to51:
						if( (minutes > 5) && (minutes < 40) ) {
							score = 60;
						} else {
							if(minutes == 40) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_52to56:
						if( (minutes > 5) && (minutes < 40) ) {
							score = 60;
						} else {
							if(minutes == 40) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_57to61:
						if( (minutes > 5) && (minutes < 41) ) {
							score = 60;
						} else {
							if(minutes == 41) {
								if(seconds == 0) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
					case AGE_62andup:
						if( (minutes > 5) && (minutes < 41) ) {
							score = 60;
						} else {
							if(minutes == 41) {
								if(seconds < 31) {
									score = 60;
								}
							} else {
								score = 0;
							}
						}
						break;
				}
				break;
		}
		
		return score;
		
	}
	
	private void calculate_score() {  // TODO
		
		int score_pushups = 0;
		int score_situps = 0;
		int score_aerobic = 0;
		int score = 0;
		
		switch(gender) {
			case MALE:
				score_pushups = calculate_pushups_male();
				score_situps = calculate_situps();
				score_aerobic = calculate_aerobic_male();
				break;
			case FEMALE:
				score_pushups = calculate_pushups_female();
				score_situps = calculate_situps();
				score_aerobic = calculate_aerobic_female();
		}
		
		if(event == RUN) {
			score = score_pushups + score_situps + score_aerobic;		
		} else {
			score = score_pushups + score_situps;	
		}
		
		edittext_score.setText( String.valueOf(score) );
		
		if( (score_pushups > 59) && (score_situps > 59) && (score_aerobic > 59) ) {
			alternate = GO;
		} else {
			alternate = NOGO;
		}
		
		switch(alternate) {
			case GO:
				textview_alternate.setTextColor(Color.GREEN);
				textview_alternate.setText("GO");
				break;
			case NOGO:
				textview_alternate.setTextColor(Color.RED);
				textview_alternate.setText("NO GO");
				break;
		}
		
	}
	
}
