# CSIEMessagingApp---Android-basic-chat-app
CSIEMessagingApp - Android firebase basic real time chat application

# Table of Contents

[1. Introduction 3](#_Toc29509920)

[1.1. Defining the problem 3](#_Toc29509921)

[1.2. Defining the objectives 3](#_Toc29509922)

[1.3. Defining the general framework 3](#_Toc29509923)

[2. Description of the solution 4](#_Toc29509924)

[2.1. Describing the usage scenarios 4](#_Toc29509925)

[2.2. Describing the functionalities 4](#_Toc29509926)

[3. Implementation of the solution 8](#_Toc29509927)

[3.1. Technical description 8](#_Toc29509928)

[3.2. Advantages/Disadvantages of Android implementation 14](#_Toc29509929)

[4. Final conclusions 15](#_Toc29509930)

1.
# Introduction

  1.
## Defining the problem

The principal aim of this project is to create a lightweight messaging application that allows conversations between two or multiple users in text format and in real-time but also has as a secondary objective to provide some strong customer/problem reporting support for users who, for a variate amount of reasons, cannot use the application as intended (authentication problems, bugs, device incompatibility and so on). The application also solves the problem of requesting a big amount of personal information (address, phone number, gender etc.) that could be collected without consent from the client for marketing purposes - a problem similar existing application have.

  1.
## Defining the objectives

In order to provide a lightweight android application, several objectives were set from the very start:

- Creating a graphical user interface that should be extremely intuitive to users of all ages, one that is straight-forward and guides users towards their intended action. Interface is not loaded with many customization settings and options in order not to confuse users who are only looking to send messages (as opposed to some other existing messaging applications such as Facebook Messenger, Snapchat, WhatsApp, Viber etc.)

- Providing in-application/direct customer support to the client by using several bug/issue reporting forms, as opposed to some of the applications mentioned above

- Providing a fast and convenient solution for small scale communities, businesses or institutions

- Simplifying the account creation – An account can be created almost instantly, requiring only an active email address a password. No other additional information is required and the user account is not tied in any way to a personal phone number (as opposed to other well-known similar applications). Therefore, user is free to create and use multiple account should he desire to do so.

  1.
## Defining the general framework

In what concerns the environment or the situations potential customers/users of this application will find themselves in that will probably determine them to want to install this application, a fact can be stated with certainty: the application, by the way it was build, is not intended for large scale/worldwide communication between strangers wanting to find friends and it is no way a social media solution. The application is more fit for connecting smaller groups of people who desire to send private messages to each other.

For example, the applications could be used by workers in a company to communicate tasks in a rapid manner between them or by students from a certain university to inform each other about where a course is taking place, when an assignment is due etc. Another, more mundane scenario that could occur is the following – a group of friends want to talk to each other, maybe without employing the use of videos, images or timestamps for messages.

1.
# Description of the solution

  1.
## Describing the usage scenarios

As it was stated before, the application is mainly targeted to small groups of people. For example, there is this next hypothetical situation: A group of 5 friends want to communicate rapidly between them and without spending to much time completing personal information they may not want to give. They can install the app and set up an account fast, using only an email address, a password and a display name. They are now ready to start chatting.

Another usage scenario: a person with a limited internet data plan want to start a conversation with another specific person, but cannot afford accidentally receiving videos or images from someone without exceeding his monthly allowance. Because of the simplified way the application was design, he may want to download this application instead of others.

  1.
## Describing the functionalities

The application can be divided into two large components/features that are separate but interdependent in order to fully attain the potential of this messaging solution.

1. **The messaging part of the application**

After launching the application from the menu of an Android device, the user will be prompted to the main screen **(Figure 2.1)** which contains a welcoming message, the application logo (which was custom made solely for the application at hand and two buttons – login and register.

When the register button is pressed, the user is prompted to create an account in order to be able to start chatting. Here, it is required to set a display name (the name by which the persons desiring to chat will recognize each other and know where to send their intended message), an email address (the use of it will be explained shortly) and of course a password. These all form the authentication data which is unique to each user of the application. **(Figure 2.2)**

The second button is the login button, which prompts the user to a new screen **(Figure 2.3)** where he can use credentials previously created in order to get ready to start sending personal messages. It is important to note that field checks will warn the user if he has forgot to fill in any required information or has done so improperly (without following the desired format). On the same screen there is also a checkbox that allows retaining the username and password so after logging in or restarting the application the clients would not be forced to refill the data every single time. This is, of course, optional.

![](RackMultipart20210718-4-1qu4suz_html_8d53fdf3f1cc544d.png) ![](RackMultipart20210718-4-1qu4suz_html_500380e3ec58f10e.png) ![](RackMultipart20210718-4-1qu4suz_html_fafcb650c250132b.png)

**Figure 2.2 – Account Creation Screen**

**Figure 2.1 - Main Screen**

**Figure 2.3 - Authentication screen**

**After pressing the login button and logging in, two sections can be accessed from this next screen.**

**Friends sections** – Which allows the user to see in a scrollable and chat with all the other users who have registered before him. In other words, all registered members are part of one big group. **(Fig. 2.4)**

**Messages sections** – It is a section that will show only the users with whom the currently logged in user had conversations (at least one message) in the past in order to provide a shortcut when the list of all registered users gets considerably larger. **(Fig 2.5)**

Both sections list the name of chat participants and a small profile image to the left of it.

In the upper bar there is also a prompt informing the user of the display name it is currently connected under. (A feature useful when someone wants to employ the use of multiple accounts for any reason he may have in mind)

Also, in the upper right corner there is a button which will allow you to initiate **two actions (Fig 2.5):**

![](RackMultipart20210718-4-1qu4suz_html_d5933ffe4fa03480.png) ![](RackMultipart20210718-4-1qu4suz_html_ed833b9f3a22fa27.png) ![](RackMultipart20210718-4-1qu4suz_html_40e0cc9bddf5be7.png) ![](RackMultipart20210718-4-1qu4suz_html_b0ed2e748d2302aa.png)

**Figure 2.7 – What the messages look like**

**Figure 2.6 – Find your location screen (Google Maps)**

**Figure 2.4 – All registered members/All Friends screen**

**Figure 2.5 – Most active conversations screen &amp; action menu**

1. **To sign out and return to the previous screen (the login one).**

An observation that must be made is that when logged in, if the back button of the Android device is pressed, the user will not be returned to the login button but will exit the application altogether. This is useful for preventing the login data to be easily stolen.

1. **To communicate your physical location in the real world**

This option will immediately prompt you to a graphical map with a marker representing your current position in the world. It also provides you the exact map coordinates at where you are currently at. Useful for setting meeting places and communicating during a conversation. **(Fig 2.6)**

When pressing the name of the user you want to communicate with, sending messages will become fairly intuitive. There is a text box on the lower part of the screen where you can type your messages (text only) and a small arrow image to the right of it to send it to the other person. Your messages will be displayed on the right part of the screen while the receiver replies will be displayed on the left along with his/her avatar. **(Fig 2.7)**

1. **The bug reporting part of the applications**

Back on the login screen **(Fig 2.3),** it can be observed that one more button is present, for whatever issue the user may have. It was designed mainly to report authentication related problems, but can be use also for other issues users may run into or simply for general feedback. Login data (usually extremely relevant for resolving client problems with the application, especially login related ones) will be automatically filled. There is also a prompt for selecting the country in which the problem occurred (may be relevant when, for example, servers for a specific country malfunctions) and of course a text cassette used for filling in any additional details for the report. **(Fig 2.8)** If the user chooses to continue, he will be prompted to a help screen **(Fig 2.9)** in which he can choose several options:

**Showing real life support centers** – Will display the available physical support centers for the application across the globe. Data such as country, town, schedule and address are available.

**Show sent reports** – Shows all the reports the user has sent in the past

**Update reports** – Gives the possibility to edit your report before finally sending it

**Delete reports** – Gives the possibility of deleting a specific report since the feature was designed in order to enable the client to send one or more separate reports at once

**Show reports sent only from a specific country**

**Export all the reports in .txt format** (ex: in the event that someone will want it printed on paper)

![](RackMultipart20210718-4-1qu4suz_html_573d0322d6a01320.png) ![](RackMultipart20210718-4-1qu4suz_html_ac07c7f0dfdd9297.png)

**Figure 2.9 – HELP screen**

**Figure 2.8 – Feedback forms screen**

1.
# Implementation of the solution

  1.
## Technical description

The main functionalities of the chat (registration, authentication and exchanging messages between two users) were implemented using Google&#39;s Firebase, a platform dedicated to developers of mobile and web applications. More specifically, two services were mainly used:

**Firebase Authentication** - represents a service that is able to authenticate the users by using client-sided code only. It also contains a graphical user management system for developers.

**Firebase Realtime Database** - A service that provides a real-time database to the developers, an API that gives the possibility to an application data to be stored in cloud and synchronized across multiple clients. It should be noted that integration is not possible only for Android platform &amp; Java language, but also for iOS/Swift, JavaScript, Objective-C, Node.JS. The database can be easily accessed by developers through a graphical interface (made with REST API).

For implementing the database **SQLite** was used. SQLite represents a software library that provides a relational database management system. The word &#39;lite&#39; in SQLite means light weight in terms of setup, database administration, and what resources it requires.

The StartActivity **(Fig 2.1)** contains two elements of type button (one for registration and one for authentication) each colored differently, a welcoming prompt taking the form of a text view element but also an image view item containing the logo of the application. The logo resource image is loaded from the internet. For this purpose, a special class called LoadInternetImage.class to load it in an asynchronous manner.

**public**** class ****LoadInternetImage**** extends** AsyncTask\&lt;String, Integer, String\&gt; {

**private** Bitmap bitmap;

**@Override**

**protected** String **doInBackground** (String... strings) {

**try** {

URL imageURL = **new** URL(strings[**0**]);

bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

} **catch** (MalformedURLException e) {

e.printStackTrace();

} **catch** (IOException e) {

e.printStackTrace();

}

**return**** null**;

}

**@Override**

**protected**** void ****onPostExecute** (String s) {

StartActivity.mainLogo.setImageBitmap(bitmap);

StartActivity.mainLogo.setImageBitmap(bitmap);

// Calling the function (in MainActivity.class)

runOnUiThread( **new** Runnable() {
@Override
**public void** run() {
**new** LoadInternetImage().execute( **&quot;https://i.imgur.com/kDpK9Rp.png&quot;** );
 }
 });

The activity&#39;s code also contains a sequence which checks if a user is logged in. If this is the case, the activity that will be started when the application is closed and restarted is the MainActivity. This is made to prevent forcing the user to login every time the application is started.

**protected void** onStart() {
**super**.onStart();

_//Authentification through Firebase
 // If a user is logged in, start Main Activity directly_ **firebaseUser** = FirebaseAuth._getInstance_().getCurrentUser();
_//Check if user is null_
**if** ( **firebaseUser**!= **null** )
 {
 Intent intent = **new** Intent(StartActivity. **this** , MainActivity. **class** );
 startActivity(intent);
 finish(); _//Dismiss activity_
}
 }

The registration screen **(Fig.2.2)** contains 3 elements of type TextInputLayout (similar to an EditText) for filling in the required data (the name under which you will be displayed, your email and password). Their attributes were changed so that the password is hidden (appears as bullet points). For the registration, which may take a bit longer depending on your internet connection, a progress bar has been set with the help of an element of type ProgressDialog. Field are checked so that the desired format is respected (ex: the password cannot have fewer than 6 characters, which is actually also a Firebase requirement). There is also TextView functioning as a title/prompt and button for finish registration.

The login screen **(Fig 2.3)** is very similar in what concerns the structure to the registration one. In addition, we have an additional button that starts the HelpActivity, which will be discussed shortly, but there is also a checkbox that, when active, will remember the login data. This eliminates the need of having to complete it every time the application is started. In order to achieve this, shared preferences were used.

**private void** managePreferences() {
**if** ( **rem\_loginInfo**.isChecked())
 {
**editor**.putString(_ **KEY\_USERNAME** _, **mLoginEmail**.getEditText().getText().toString().trim());
**editor**.putString(_ **KEY\_PASSWORD** _, **mLoginPassword**.getEditText().getText().toString().trim());
**editor**.putBoolean(_ **KEY\_REMEMBER** _, **true** );
**editor**.apply();
 }
**else**
{
**editor**.putBoolean(_ **KEY\_REMEMBER** _, **false** );
**editor**.remove(_ **KEY\_PASSWORD** _);
**editor**.remove(_ **KEY\_USERNAME** _);
**editor**.apply();
 }
 }

FeedbackForm activity is started once the user presses the specific button on the login screen. During the button press, an object of type &#39;User&#39; (a special classed called &#39;User&#39; containing username, id, password and and imageURL for the profile image and basic constructors &amp; getters and setters) is sent to the FeedbackForm, so that the corresponding fields will be automatically completed. The activity contains several labels for the fields and some instructions (as elements of type TextView), elements of type EditText for email and password (that are auto filled with the data passed from the login activity), and detailed report. There is also a spinner for selecting the country where you may encounter a problem to the application. These were all considered data relevant for error reporting. For the spinner an adapter was built. There are also 4 buttons for sending a report, updating it, loading data for edit and delete report (their scope will be discussed in the paragraphs to come). The reason for which bug/feedback reporting was implemented this way was because it gives the possibility to the user to sent multiple ones at once and also to edit or delete a report before finally sending it, giving him more control over this feature. The final database that results can be sent across internet to a MySQL Web Server collecting all the reports for several users. This is a feature that may be implemented in the future.

/// Passed in the Login Activity

userObject = **new** User(password\_completed, email\_completed);
 passUserObject.putExtra( **&quot;objectToPass&quot;** , userObject);
 startActivity(passUserObject);

///Received in the FeedbackForm activity

**receivedUser** = **new** User();
 Intent i = getIntent();
**receivedUser** = (User) i.getSerializableExtra( **&quot;objectToPass&quot;** );

**email\_et**.setText( **receivedUser**.getEmail());
**password\_et**.setText( **receivedUser**.getPassword());

/// Adapter for spinner

ArrayAdapter\&lt;CharSequence\&gt; adapter = ArrayAdapter._createFromResource_( **this** , R.array._ **Countries** _, android.R.layout._ **simple\_spinner\_item** _);
 adapter.setDropDownViewResource(android.R.layout._ **simple\_spinner\_dropdown\_item** _);
**countrySelectSpinner**.setAdapter(adapter);
**countrySelectSpinner**.setOnItemSelectedListener( **this** );

HelpActivity – Contains 6 buttons meant to control the editing of the database (CRUD operations – Create, Read, Update, Delete) and an element of type ScrollView. For implementing the database using SQLite, a special class called DatabaseHelper was created, retaining information such as the name of the database, methods for database operations/queries and the overall structure of the table. One important aspect that should that should definitely be mentioned is that, because of the way it was designed, a report can only be edited or deleted based by an ID you receive for it. If you press the specific button, you will be returned to the previous activity and be prompted to make your changes. Using the buttons that were implemented in HelpActivity, reports can be visualized within an AlertDialogue. For getting the data corresponding to the location of some support centers for the application, a json file is retrieved in an asynchronous manner from the internet (more specifically, from where it is uploaded, at myjson.com - using the custom-made class fetchJsonData.class) and

// Function for showing custom reports from the database in the application

**public void** showTheMessage(String title, String message) {
 AlertDialog.Builder builder = **new** AlertDialog.Builder( **this** );
 builder.setCancelable( **true** );
 builder.setTitle(title);
 builder.setMessage(message);
 builder.show();
 }

MessagingActivity – Contains two fragments, one for the &#39;Friends&#39; section (meaning all the users registered in the application) and one for &#39;Friends sections&#39; (used as a &#39;favorite conversations&#39; section). In order to be able to switch between these two sections with a simple swipe, a custom adapter was created, called AdapterPagerSections (which extends FragmentPagerAdapter from Android Default Library)

**class** AdapterPagerSections **extends** FragmentPagerAdapter {

**public** AdapterPagerSections(@NonNull FragmentManager fm) {
**super** (fm);
 }

@NonNull
 @Override
**public** Fragment getItem( **int** position) {

**switch** (position)
 {
**case** 0: FragmentFriends fragmentFriends = **new** FragmentFriends();
**return** fragmentFriends;

**case** 1: FragmentMessages fragmentMessages = **new** FragmentMessages();
**return** fragmentMessages;

_//case 2: --- If further fragments are added_


**default** :
**return null** ;
 }
 }

**public** CharSequence getPageTitle( **int** position) {
_///We set the title of the tabs here_
**switch** (position)
 {
**case** 0: **return**  **&quot;FRIENDS&quot;** ;
**case** 1: **return**  **&quot;MESSAGES&quot;** ;
_//case 2: return &quot;FRIEND REQUESTS&quot;; --if we wanted to add one more, for example_
**default** : **return null** ;
 }
 }

@Override
**public int** getCount() {
**return** 2; _//because we have 2 tabs only_
}
 }

It contains elements of type TextView, CircleImage view (for the profile image), ImageButton (an arrow that when pressed sends the message – a resource file coming from the default images provided by Android Studio). For showing the messages, an adapter called AdapterShowMessages was created (which extends RecyclerView). The AdapterShowMessages uses a library called Glide (an open source image loader and media management for Android, that focuses on smooth scrolling) for the purpose of making profile image management easier.

Inside the AdapterShowMessages ,with the help of LayoutInflater, two types of view are integrated: one for the text bubbles of the person your are talking to (chat\_right\_item, positioned on the right side of the screen) and one for the text bubbles corresponding to your messages ( chat\_left\_item, positioned on the left side of the screen). Their layouts are formed by a TextView and a CircleImageView (corresponding to the avatar). For fully functioning, this adapter uses a List\&lt;Chats\&gt; where Chats is simple an intermediary class containing as strings corresponding to the sender, receiver and the messages, because this is how they are stored in Firebase. **(Figure 3.1)**

\&lt; **de.hdodenhof.circleimageview.CircleImageView**
**android**** :id ****=&quot;@+id/profile\_image&quot;**
**android**** :src ****=&quot;@mipmap/ic\_launcher&quot;**
**android**** :layout\_width ****=&quot;40dp&quot;**
**android**** :layout\_height ****=&quot;40dp&quot;** /\&gt;

 \&lt; **TextView**
**android**** :id ****=&quot;@+id/show\_message&quot;**
**android**** :textSize ****=&quot;20sp&quot;**
**android**** :layout\_width ****=&quot;wrap\_content&quot;**
**android**** :layout\_height ****=&quot;wrap\_content&quot;**
**android**** :background ****=&quot;@drawable/background\_left&quot;**
**android**** :layout\_toRightOf ****=&quot;@id/profile\_image&quot;**
**android**** :layout\_marginLeft ****=&quot;5dp&quot;**
**android**** :text ****=&quot;@string/welcome\_prompt&quot;**
**android**** :padding ****=&quot;10dp&quot;** /\&gt;

![](RackMultipart20210718-4-1qu4suz_html_e541d4b3c0fad752.png)

**Figure 3.1 – How data corresponding to a message is stored in the Firebase Realtime Database**

![](RackMultipart20210718-4-1qu4suz_html_34842f6b6a7fb5f9.png)

UserAdapter.class – Very similar to AdapterShowMessage.class – an adapter which is set for the recyclerView in order to display users

GMapsActivity.class is used for displaying your current location. It extends FragmentActivity and inside it it a marker is set to point your exact location. Zooming is performed automatically (it would be difficult to spot otherwise). It uses ACCESS\_FINE\_LOCATION permission in order to pinpoint your exact position, as opposed to ACCESS\_COARSE\_LOCATION which would only pinpoint your position with an accuracy equivalent to a city block. Of course, for this to work, the device&#39;s GPS/location must be on. The map is loaded asynchronous (this is the default implementation).

@Override
**public void** onMapReady(GoogleMap googleMap) {
 LatLng latLng = **new** LatLng( **currentUserLocation**.getLatitude(), **currentUserLocation**.getLongitude());
 MarkerOptions markerOptions = **new** MarkerOptions().position(latLng).title( **&quot;This is my current location&quot;** );
 googleMap.animateCamera(CameraUpdateFactory._newLatLng_(latLng));
 googleMap.animateCamera(CameraUpdateFactory._newLatLngZoom_(latLng, 5)); //performs zooming on the map
 googleMap.addMarker(markerOptions);

 }

  1.
## Advantages/Disadvantages of Android implementation

**Advantages:**

- A large array of articles, books, guides and overall documentation available online and in libraries
- A large array of pre-defined libraries (official or third party) you can use
- Possibility of sharing your application easily with others (Google&#39;s Play Store)
- Android&#39;s Gradle taking care of dynamically importing the libraries you need
- Application can be tested without much hassle directly on your Android device while developing it (should you own such a device)

**Disadvantages:**

- Designing the layout for an application you are developing is somehow unintuitive, slow and cumbersome, especially when compared to implementing the solution on Windows (Ex: Windows Visual Studio and C#)
- Scalability on different devices or compatibility is often a problem and a challenge to solve
- Powerful PC needed in order for the developing environment to run, especially if you cannot test it on an Android device and must emulate it

1.
# Final conclusions

The conclusion is that, for a smaller scale of usage, Google&#39;s Firebase represents the best solution for persisting the data (authentication info, messages in text format and not only) and communicating in real-time. It is undoubtedly at least a better solution than persisting the data locally, which will only make communication possible on the same device. There is of course the option of sending the database after each message between users with the help of internet, but it would be a very significant technical slowdown. As stated before, Firebase provides a fairly easy to implement solution (as opposed to the hardships of implementing a real-time database yourself) that is heavily documented across the internet by Google itself or by partners or simply by users across the globe. It is also free of charge, unless of course you want extend your applications in what concerns capacity or making it commercially available to a large of array of clients across the globe (there are pay plans for enabling the everyday programmer to do so)

# 5 Bibliography

Bates, Kathy Sierra &amp; Bert. 2005. _Head First Java - 2nd Edition._ Salt Lake City: Shroff/O&#39;Reilly.

2019. _dev.to._ 8 6. Accessed 11 24, 2019. https://dev.to/tvanblargan/getting-started-with-firebase-authentication-2bg7.

2012. &quot;Excerpt from &quot;The Busy Coder&#39;s Guide to Android Development&quot; .&quot; _commonsware.com._ Accessed 11 20, 2019. https://commonsware.com/Android/excerpt.pdf.

Google Comapny. n.d. _firebase.google.com._ Accessed 11 12, 2019. https://firebase.google.com/docs/database/.

Joe. 2014. _JavaPapers.com._ 7 25. Accessed 1 3, 2020. https://javapapers.com/android/android-chat-bubble/.

Moroney, Laurence. 2017. _The Definitive Guide to Firebase: Build Android Apps on Google&#39;s Mobile Platform._ Apress.

Oracle America. 2015. _The Java Language Specification ._ Redwood City.

POCATILU, Paul. 2012. _Programarea dispozitivelor mobile._ Bucuresti: Editura ASE, Bucuresti,.

S, Ashok Kumar. 2018. _Mastering Firebase for Android Development._ Packt Publishing.

SATISH, RAM. 2015. _JavaArticles.com._ 4 22. Accessed 1 2, 2020. https://www.javarticles.com/2015/04/android-sqlite-example.html.

2018. _Smashingmagazine.com._ 21 12. Accessed 11 1, 2019. https://www.smashingmagazine.com/2018/02/comprehensive-guide-to-mobile-app-design/.

Smyth, Neil. 2019. _Android Studio 3.5 Development Essentials - Java Edition._ Payload Media.

Zapata, Belén Cruz. 2016. _Android Studio 2 Essentials - Second Edition._ Packt Publishing.
