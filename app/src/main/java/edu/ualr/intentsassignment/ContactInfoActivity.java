package edu.ualr.intentsassignment;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ualr.intentsassignment.Utils.Entry;
import edu.ualr.intentsassignment.databinding.ContactInfoActivityBinding;


public class ContactInfoActivity extends AppCompatActivity {
    private ContactInfoActivityBinding binding;
    private Entry saved_entry;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ContactInfoActivityBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        saved_entry = getIntent().getParcelableExtra(ContactFormActivity.ENTRY_KEY);
        if (saved_entry != null){
            display_info();
            initChips();
        }


    }
    private void display_info(){
        this.binding.nameInfoView
                .setText(saved_entry.getPerson_first_name() + " " + saved_entry.getPerson_last_name());
        this.binding.phoneInfoView.setText(this.saved_entry.getPhone_number());
        this.binding.emailInfoView.setText(this.saved_entry.getEmail());
        this.binding.addressInfoView.setText(this.saved_entry.getAddress());
        this.binding.websiteInfoView.setText(this.saved_entry.getWebsite());
    }

    private void initChips(){
        this.binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + saved_entry.getPhone_number()));
                startActivity(call);
            }
        });
        this.binding.webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web_search = new Intent(Intent.ACTION_WEB_SEARCH);
                web_search.putExtra(SearchManager.QUERY, saved_entry.getWebsite());
                startActivity(web_search);
            }
        });
        this.binding.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send_mail = new Intent(Intent.ACTION_SEND);
                send_mail.putExtra(Intent.EXTRA_EMAIL, new String[] {saved_entry.getEmail()});
                send_mail.setType("text/plain");
                startActivity(Intent.createChooser(send_mail, ""));
            }
        });
        this.binding.mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search_loc = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("geo:0,0?q=(%s)", saved_entry.getAddress())));
                startActivity(search_loc);
            }
        });
        this.binding.textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send_text = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + saved_entry.getPhone_number()));
                startActivity(send_text);

            }
        });
    }

    // TODO 03. Create a new layout file to define the GUI elements of the ContactInfoActivity.
    // TODO 04. Define the basic skeleton of the ContactInfoActivity. Inflate the layout defined in the first step to display the GUI elements on screen.
    // TODO 07. Create a new method that reads the contact info coming from ContactFormActivity and use it to populate the several TextView elements in the layout.
    // TODO 08. Create a new method that invokes a Phone Dialer app, using as parameter the phone number included in the contact info received from ContactFormActivity in the previous step
    // TODO 09. Create a new method that invokes a Messages app, using as parameter the phone number included in the contact info received from ContactFormActivity in the 7th step
    // TODO 10. Create a new method that invokes a Maps app, using as parameter the address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 11. Create a new method that invokes an Email app, using as parameter the email address included in the contact info received from ContactFormActivity in the 7th step
    // TODO 12. Create a new method that invokes an Web Browser app, using as parameter the web url included in the contact info received from ContactFormActivity in the 7th step
}
