package edu.ualr.intentsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.Utils.Entry;
import edu.ualr.intentsassignment.databinding.ContactFormActivityBinding;


public class ContactFormActivity extends AppCompatActivity {
    private ContactFormActivityBinding binding;
    public static final String ENTRY_KEY = "entry";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ContactFormActivityBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());



        this.binding.saveContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContactInfoActivity.class);
                saveUserInput(intent);
                startActivity(intent);
            }
        });
    }

    private void saveUserInput(Intent intent){
        Entry new_entry = new Entry(
               this.binding.inputPersonName.getText().toString(),
               this.binding.inputLastName.getText().toString(),
               this.binding.inputEmail.getText().toString(),
                this.binding.inputPhone.getText().toString(),
                this.binding.inputWebsite.getText().toString(),
                this.binding.inputAddress.getText().toString()
        );

        intent.putExtra(ENTRY_KEY, new_entry);
    }
// TODO 01. Create a new layout file to define the GUI elements of the ContactFormActivity.
    // TODO 02. Define the basic skeleton of the ContactFormActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 06. Create a new method that reads the values in the several EditText elements of the layout and then uses the Contact class to send those data to ContactInfoActivity
}
