package com.techblogon.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity
{
	EditText editTextUserName,editTextPassword,editTextConfirmPassword,editTextFirstName,editTextDOB,editTextLastName,editTextEmail,editTextPhonenumber,editTextFathersN,editTextFathersNU,editTextMN, editTextMNU;
	Button btnCreateAccount;
	
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		// get Instance  of Database Adapter
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		// Get Refferences of Views
		editTextUserName=(EditText)findViewById(R.id.editTextUserName);
		editTextPassword=(EditText)findViewById(R.id.editTextPassword);
		editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
		editTextFirstName=(EditText)findViewById(R.id.editFirstName);
		editTextLastName=(EditText)findViewById(R.id.editLastName);
		editTextPhonenumber=(EditText)findViewById(R.id.editTextPhoneNumber);
		editTextEmail=(EditText)findViewById(R.id.editTextEmail);
		editTextFathersN=(EditText)findViewById(R.id.editTextPAPANAME);
		editTextFathersNU=(EditText)findViewById(R.id.editTextFathersPhone);
		editTextMN=(EditText)findViewById(R.id.editTextMAMANAME);
		editTextMNU=(EditText)findViewById(R.id.editTextMothersPhone);
		editTextDOB=(EditText)findViewById(R.id.editTextDOB);

		btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String userName=editTextUserName.getText().toString();
			String password=editTextPassword.getText().toString();
			String confirmPassword=editTextConfirmPassword.getText().toString();
			String firstname=editTextFirstName.getText().toString();
			String lastname=editTextLastName.getText().toString();
			String phone=editTextPhonenumber.getText().toString();
			String email=editTextEmail.getText().toString();
			String PN=editTextFathersN.getText().toString();
			String PNU=editTextFathersNU.getText().toString();
			String MN=editTextMN.getText().toString();
			String MNU =editTextMNU.getText().toString();
			String DOB =editTextDOB.getText().toString();

			// check if any of the fields are vaccant
			if(userName.equals("")||password.equals("")||DOB.equals((""))||confirmPassword.equals("")||firstname.equals("")||lastname.equals("")||email.equals("")||phone.equals("")||PN.equals("")||PNU.equals("")||MN.equals("")||MNU.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
					return;
			}
			// check if both password matches
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
				return;
			}
			else
			{
			    // Save the Data in Database
			    loginDataBaseAdapter.insertEntry(userName, password);
			    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
			}
		}
	});
}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		loginDataBaseAdapter.close();
	}
}
