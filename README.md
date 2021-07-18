# Table of Contents

[1. Introduction 3](#introduction)

[1.1. Defining the problem 3](#defining-the-problem)

[1.2. Defining the objectives 3](#defining-the-objectives)

[1.3. Defining the general framework 3](#defining-the-general-framework)

[2. Description of the solution 4](#description-of-the-solution)

[2.1. Describing the usage scenarios 4](#describing-the-usage-scenarios)

[2.2. Describing the functionalities 4](#describing-the-functionalities)

[3. Implementation of the solution 8](#implementation-of-the-solution)

[3.1. Technical description 8](#technical-description)

[3.2. Advantages/Disadvantages of Android implementation
14](#advantagesdisadvantages-of-android-implementation)

[4. Final conclusions 15](#final-conclusions)

1.  # Introduction

    1.  ##  Defining the problem

The principal aim of this project is to create a lightweight messaging
application that allows conversations between two or multiple users in
text format and in real-time but also has as a secondary objective to
provide some strong customer/problem reporting support for users who,
for a variate amount of reasons, cannot use the application as intended
(authentication problems, bugs, device incompatibility and so on). The
application also solves the problem of requesting a big amount of
personal information (address, phone number, gender etc.) that could be
collected without consent from the client for marketing purposes - a
problem similar existing application have.

##  Defining the objectives

In order to provide a lightweight android application, several
objectives were set from the very start:

-   Creating a graphical user interface that should be extremely
    intuitive to users of all ages, one that is straight-forward and
    guides users towards their intended action. Interface is not loaded
    with many customization settings and options in order not to confuse
    users who are only looking to send messages (as opposed to some
    other existing messaging applications such as Facebook Messenger,
    Snapchat, WhatsApp, Viber etc.)

-   Providing in-application/direct customer support to the client by
    using several bug/issue reporting forms, as opposed to some of the
    applications mentioned above

-   Providing a fast and convenient solution for small scale
    communities, businesses or institutions

-   Simplifying the account creation – An account can be created almost
    instantly, requiring only an active email address a password. No
    other additional information is required and the user account is not
    tied in any way to a personal phone number (as opposed to other
    well-known similar applications). Therefore, user is free to create
    and use multiple account should he desire to do so.

    1.  ##  Defining the general framework

In what concerns the environment or the situations potential
customers/users of this application will find themselves in that will
probably determine them to want to install this application, a fact can
be stated with certainty: the application, by the way it was build, is
not intended for large scale/worldwide communication between strangers
wanting to find friends and it is no way a social media solution. The
application is more fit for connecting smaller groups of people who
desire to send private messages to each other.

For example, the applications could be used by workers in a company to
communicate tasks in a rapid manner between them or by students from a
certain university to inform each other about where a course is taking
place, when an assignment is due etc. Another, more mundane scenario
that could occur is the following – a group of friends want to talk to
each other, maybe without employing the use of videos, images or
timestamps for messages.

2.  # Description of the solution

    1.  ##  Describing the usage scenarios

As it was stated before, the application is mainly targeted to small
groups of people. For example, there is this next hypothetical
situation: A group of 5 friends want to communicate rapidly between them
and without spending to much time completing personal information they
may not want to give. They can install the app and set up an account
fast, using only an email address, a password and a display name. They
are now ready to start chatting.

Another usage scenario: a person with a limited internet data plan want
to start a conversation with another specific person, but cannot afford
accidentally receiving videos or images from someone without exceeding
his monthly allowance. Because of the simplified way the application was
design, he may want to download this application instead of others.

##  Describing the functionalities

The application can be divided into two large components/features that
are separate but interdependent in order to fully attain the potential
of this messaging solution.

1.  **The messaging part of the application**

After launching the application from the menu of an Android device, the
user will be prompted to the main screen **(Figure 2.1)** which contains
a welcoming message, the application logo (which was custom made solely
for the application at hand and two buttons – login and register.

When the register button is pressed, the user is prompted to create an
account in order to be able to start chatting. Here, it is required to
set a display name (the name by which the persons desiring to chat will
recognize each other and know where to send their intended message), an
email address (the use of it will be explained shortly) and of course a
password. These all form the authentication data which is unique to each
user of the application. **(Figure 2.2)**

The second button is the login button, which prompts the user to a new
screen **(Figure 2.3)** where he can use credentials previously created
in order to get ready to start sending personal messages. It is
important to note that field checks will warn the user if he has forgot
to fill in any required information or has done so improperly (without
following the desired format). On the same screen there is also a
checkbox that allows retaining the username and password so after
logging in or restarting the application the clients would not be forced
to refill the data every single time. This is, of course, optional.

<img src=".\media/image1.png" style="width:1.92in;height:3.85in" /><img src=".\media/image2.png" style="width:1.90833in;height:3.84814in" /><img src=".\media/image3.png" style="width:1.93in;height:3.85in" />

**After pressing the login button and logging in, two sections can be
accessed from this next screen.**

**Friends sections** – Which allows the user to see in a scrollable and
chat with all the other users who have registered before him. In other
words, all registered members are part of one big group. **(Fig. 2.4)**

**Messages sections** – It is a section that will show only the users
with whom the currently logged in user had conversations (at least one
message) in the past in order to provide a shortcut when the list of all
registered users gets considerably larger. **(Fig 2.5)**

Both sections list the name of chat participants and a small profile
image to the left of it.

In the upper bar there is also a prompt informing the user of the
display name it is currently connected under. (A feature useful when
someone wants to employ the use of multiple accounts for any reason he
may have in mind)

Also, in the upper right corner there is a button which will allow you
to initiate **two actions (Fig 2.5):**

<img src=".\media/image4.png" style="width:1.90972in;height:3.78958in" /><img src=".\media/image5.png" style="width:1.9in;height:3.79in" /><img src=".\media/image6.png" style="width:1.91in;height:3.79in" /><img src=".\media/image7.png" style="width:1.90972in;height:3.78958in" />

1.  **To sign out and return to the previous screen (the login one).**

An observation that must be made is that when logged in, if the back
button of the Android device is pressed, the user will not be returned
to the login button but will exit the application altogether. This is
useful for preventing the login data to be easily stolen.

2.  **To communicate your physical location in the real world**

This option will immediately prompt you to a graphical map with a marker
representing your current position in the world. It also provides you
the exact map coordinates at where you are currently at. Useful for
setting meeting places and communicating during a conversation. **(Fig
2.6)**

When pressing the name of the user you want to communicate with, sending
messages will become fairly intuitive. There is a text box on the lower
part of the screen where you can type your messages (text only) and a
small arrow image to the right of it to send it to the other person.
Your messages will be displayed on the right part of the screen while
the receiver replies will be displayed on the left along with his/her
avatar. **(Fig 2.7)**

2.  **The bug reporting part of the applications**

Back on the login screen **(Fig 2.3),** it can be observed that one more
button is present, for whatever issue the user may have. It was designed
mainly to report authentication related problems, but can be use also
for other issues users may run into or simply for general feedback.
Login data (usually extremely relevant for resolving client problems
with the application, especially login related ones) will be
automatically filled. There is also a prompt for selecting the country
in which the problem occurred (may be relevant when, for example,
servers for a specific country malfunctions) and of course a text
cassette used for filling in any additional details for the report.
**(Fig 2.8)** If the user chooses to continue, he will be prompted to a
help screen **(Fig 2.9)** in which he can choose several options:

**Showing real life support centers** – Will display the available
physical support centers for the application across the globe. Data such
as country, town, schedule and address are available.

**Show sent reports** – Shows all the reports the user has sent in the
past

**Update reports** – Gives the possibility to edit your report before
finally sending it

**Delete reports** – Gives the possibility of deleting a specific report
since the feature was designed in order to enable the client to send one
or more separate reports at once

**Show reports sent only from a specific country**

**Export all the reports in .txt format** (ex: in the event that someone
will want it printed on paper)

<img src=".\media/image8.png" style="width:1.91944in;height:3.80972in" /><img src=".\media/image9.png" style="width:1.90972in;height:3.81944in" />

3.  # Implementation of the solution

    1.  ##  Technical description

The main functionalities of the chat (registration, authentication and
exchanging messages between two users) were implemented using Google’s
Firebase, a platform dedicated to developers of mobile and web
applications. More specifically, two services were mainly used:

**Firebase Authentication** - represents a service that is able to
authenticate the users by using client-sided code only. It also contains
a graphical user management system for developers.

**Firebase Realtime Database** - A service that provides a real-time
database to the developers, an API that gives the possibility to an
application data to be stored in cloud and synchronized across multiple
clients. It should be noted that integration is not possible only for
Android platform & Java language, but also for iOS/Swift, JavaScript,
Objective-C, Node.JS. The database can be easily accessed by developers
through a graphical interface (made with REST API).

For implementing the database **SQLite** was used. SQLite represents a
software library that provides a relational database management system.
The word ‘lite’ in SQLite means light weight in terms of setup, database
administration, and what resources it requires.

The StartActivity **(Fig 2.1)** contains two elements of type button
(one for registration and one for authentication) each colored
differently, a welcoming prompt taking the form of a text view element
but also an image view item containing the logo of the application. The
logo resource image is loaded from the internet. For this purpose, a
special class called LoadInternetImage.class to load it in an
asynchronous manner.

**public** **class** **LoadInternetImage** **extends**
AsyncTask\<String, Integer, String> {

**private** Bitmap bitmap;

**@Override**

**protected** String **doInBackground**(String... strings) {

**try** {

URL imageURL = **new** URL(strings\[**0**\]);

bitmap =
BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

} **catch** (MalformedURLException e) {

e.printStackTrace();

} **catch** (IOException e) {

e.printStackTrace();

}

**return** **null**;

}

**@Override**

**protected** **void** **onPostExecute**(String s) {

StartActivity.mainLogo.setImageBitmap(bitmap);

StartActivity.mainLogo.setImageBitmap(bitmap);

// Calling the function (in MainActivity.class)

runOnUiThread(**new** Runnable() {  
@Override  
**public void** run() {  
**new**
LoadInternetImage().execute(**"https://i.imgur.com/kDpK9Rp.png"**);  
}  
});

The activity’s code also contains a sequence which checks if a user is
logged in. If this is the case, the activity that will be started when
the application is closed and restarted is the MainActivity. This is
made to prevent forcing the user to login every time the application is
started.

**protected void** onStart() {  
**super**.onStart();  
  
*//Authentification through Firebase  
// If a user is logged in, start Main Activity directly  
***firebaseUser** = FirebaseAuth.*getInstance*().getCurrentUser();  
*//Check if user is null  
***if**(**firebaseUser** !=**null**)  
{  
Intent intent = **new** Intent(StartActivity.**this**,
MainActivity.**class**);  
startActivity(intent);  
finish(); *//Dismiss activity  
*}  
}

The registration screen **(Fig.2.2)** contains 3 elements of type
TextInputLayout (similar to an EditText) for filling in the required
data (the name under which you will be displayed, your email and
password). Their attributes were changed so that the password is hidden
(appears as bullet points). For the registration, which may take a bit
longer depending on your internet connection, a progress bar has been
set with the help of an element of type ProgressDialog. Field are
checked so that the desired format is respected (ex: the password cannot
have fewer than 6 characters, which is actually also a Firebase
requirement). There is also TextView functioning as a title/prompt and
button for finish registration.

The login screen **(Fig 2.3)** is very similar in what concerns the
structure to the registration one. In addition, we have an additional
button that starts the HelpActivity, which will be discussed shortly,
but there is also a checkbox that, when active, will remember the login
data. This eliminates the need of having to complete it every time the
application is started. In order to achieve this, shared preferences
were used.

**private void** managePreferences() {  
**if**(**rem_loginInfo**.isChecked())  
{  
**editor**.putString(***KEY_USERNAME***,
**mLoginEmail**.getEditText().getText().toString().trim());  
**editor**.putString(***KEY_PASSWORD***,
**mLoginPassword**.getEditText().getText().toString().trim());  
**editor**.putBoolean(***KEY_REMEMBER***, **true**);  
**editor**.apply();  
}  
**else  
**{  
**editor**.putBoolean(***KEY_REMEMBER***, **false**);  
**editor**.remove(***KEY_PASSWORD***);  
**editor**.remove(***KEY_USERNAME***);  
**editor**.apply();  
}  
}

FeedbackForm activity is started once the user presses the specific
button on the login screen. During the button press, an object of type
‘User’ (a special classed called ‘User’ containing username, id,
password and and imageURL for the profile image and basic constructors &
getters and setters) is sent to the FeedbackForm, so that the
corresponding fields will be automatically completed. The activity
contains several labels for the fields and some instructions (as
elements of type TextView), elements of type EditText for email and
password (that are auto filled with the data passed from the login
activity), and detailed report. There is also a spinner for selecting
the country where you may encounter a problem to the application. These
were all considered data relevant for error reporting. For the spinner
an adapter was built. There are also 4 buttons for sending a report,
updating it, loading data for edit and delete report (their scope will
be discussed in the paragraphs to come). The reason for which
bug/feedback reporting was implemented this way was because it gives the
possibility to the user to sent multiple ones at once and also to edit
or delete a report before finally sending it, giving him more control
over this feature. The final database that results can be sent across
internet to a MySQL Web Server collecting all the reports for several
users. This is a feature that may be implemented in the future.

/// Passed in the Login Activity

userObject = **new** User(password_completed, email_completed);  
passUserObject.putExtra(**"objectToPass"**, userObject);  
startActivity(passUserObject);

///Received in the FeedbackForm activity

**receivedUser** = **new** User();  
Intent i = getIntent();  
**receivedUser** = (User) i.getSerializableExtra(**"objectToPass"**);  
  
**email_et**.setText(**receivedUser**.getEmail());  
**password_et**.setText(**receivedUser**.getPassword());

/// Adapter for spinner

ArrayAdapter\<CharSequence> adapter =
ArrayAdapter.*createFromResource*(**this**, R.array.***Countries***,
android.R.layout.***simple_spinner_item***);  
adapter.setDropDownViewResource(android.R.layout.***simple_spinner_dropdown_item***);  
**countrySelectSpinner**.setAdapter(adapter);  
**countrySelectSpinner**.setOnItemSelectedListener(**this**);

HelpActivity – Contains 6 buttons meant to control the editing of the
database (CRUD operations – Create, Read, Update, Delete) and an element
of type ScrollView. For implementing the database using SQLite, a
special class called DatabaseHelper was created, retaining information
such as the name of the database, methods for database
operations/queries and the overall structure of the table. One important
aspect that should that should definitely be mentioned is that, because
of the way it was designed, a report can only be edited or deleted based
by an ID you receive for it. If you press the specific button, you will
be returned to the previous activity and be prompted to make your
changes. Using the buttons that were implemented in HelpActivity,
reports can be visualized within an AlertDialogue. For getting the data
corresponding to the location of some support centers for the
application, a json file is retrieved in an asynchronous manner from the
internet (more specifically, from where it is uploaded, at myjson.com -
using the custom-made class fetchJsonData.class) and

// Function for showing custom reports from the database in the
application

**public void** showTheMessage(String title, String message) {  
AlertDialog.Builder builder = **new** AlertDialog.Builder(**this**);  
builder.setCancelable(**true**);  
builder.setTitle(title);  
builder.setMessage(message);  
builder.show();  
}

MessagingActivity – Contains two fragments, one for the ‘Friends’
section (meaning all the users registered in the application) and one
for ‘Friends sections’ (used as a ‘favorite conversations’ section). In
order to be able to switch between these two sections with a simple
swipe, a custom adapter was created, called AdapterPagerSections (which
extends FragmentPagerAdapter from Android Default Library)

**class** AdapterPagerSections **extends** FragmentPagerAdapter {  
  
**public** AdapterPagerSections(@NonNull FragmentManager fm) {  
**super**(fm);  
}  
  
@NonNull  
@Override  
**public** Fragment getItem(**int** position) {  
  
**switch** (position)  
{  
**case** 0: FragmentFriends fragmentFriends = **new**
FragmentFriends();  
**return** fragmentFriends;  
  
**case** 1: FragmentMessages fragmentMessages = **new**
FragmentMessages();  
**return** fragmentMessages;  
  
*//case 2: --- If further fragments are added  
  
  
***default**:  
**return null**;  
}  
}  
  
**public** CharSequence getPageTitle(**int** position) {  
*///We set the title of the tabs here  
***switch**(position)  
{  
**case** 0: **return "FRIENDS"**;  
**case** 1: **return "MESSAGES"**;  
*//case 2: return "FRIEND REQUESTS"; --if we wanted to add one more, for
example  
***default**: **return null**;  
}  
}  
  
@Override  
**public int** getCount() {  
**return** 2; *//because we have 2 tabs only  
*}  
}

It contains elements of type TextView, CircleImage view (for the profile
image), ImageButton (an arrow that when pressed sends the message – a
resource file coming from the default images provided by Android
Studio). For showing the messages, an adapter called AdapterShowMessages
was created (which extends RecyclerView). The AdapterShowMessages uses a
library called Glide (an open source image loader and media management
for Android, that focuses on smooth scrolling) for the purpose of making
profile image management easier.

Inside the AdapterShowMessages ,with the help of LayoutInflater, two
types of view are integrated: one for the text bubbles of the person
your are talking to (chat_right_item, positioned on the right side of
the screen) and one for the text bubbles corresponding to your messages
( chat_left_item, positioned on the left side of the screen). Their
layouts are formed by a TextView and a CircleImageView (corresponding to
the avatar). For fully functioning, this adapter uses a List\<Chats>
where Chats is simple an intermediary class containing as strings
corresponding to the sender, receiver and the messages, because this is
how they are stored in Firebase. **(Figure 3.1)**

\<**de.hdodenhof.circleimageview.CircleImageView  
android:id="@+id/profile_image"  
android:src="@mipmap/ic_launcher"  
android:layout_width="40dp"  
android:layout_height="40dp"**/>  
  
\<**TextView  
android:id="@+id/show_message"  
android:textSize="20sp"  
android:layout_width="wrap_content"  
android:layout_height="wrap_content"  
android:background="@drawable/background_left"  
android:layout_toRightOf="@id/profile_image"  
android:layout_marginLeft="5dp"  
android:text="@string/welcome_prompt"  
android:padding="10dp"**/>

<img src=".\media/image10.png" style="width:5.00833in;height:1.87125in" />

Figure 3.1 – How data corresponding to a message is stored in the
Firebase Realtime Database

<img src=".\media/image11.png" style="width:6.49653in;height:1.08125in" />

UserAdapter.class – Very similar to AdapterShowMessage.class – an
adapter which is set for the recyclerView in order to display users

GMapsActivity.class is used for displaying your current location. It
extends FragmentActivity and inside it it a marker is set to point your
exact location. Zooming is performed automatically (it would be
difficult to spot otherwise). It uses ACCESS_FINE_LOCATION permission in
order to pinpoint your exact position, as opposed to
ACCESS_COARSE_LOCATION which would only pinpoint your position with an
accuracy equivalent to a city block. Of course, for this to work, the
device’s GPS/location must be on. The map is loaded asynchronous (this
is the default implementation).

@Override  
**public void** onMapReady(GoogleMap googleMap) {  
LatLng latLng = **new** LatLng(**currentUserLocation**.getLatitude(),
**currentUserLocation**.getLongitude());  
MarkerOptions markerOptions = **new**
MarkerOptions().position(latLng).title(**"This is my current
location"**);  
googleMap.animateCamera(CameraUpdateFactory.*newLatLng*(latLng));  
googleMap.animateCamera(CameraUpdateFactory.*newLatLngZoom*(latLng, 5));
//performs zooming on the map  
googleMap.addMarker(markerOptions);  
  
}

##  Advantages/Disadvantages of Android implementation

**Advantages:**

-   A large array of articles, books, guides and overall documentation
    available online and in libraries

-   A large array of pre-defined libraries (official or third party) you
    can use

-   Possibility of sharing your application easily with others (Google’s
    Play Store)

-   Android’s Gradle taking care of dynamically importing the libraries
    you need

-   Application can be tested without much hassle directly on your
    Android device while developing it (should you own such a device)

**Disadvantages:**

-   Designing the layout for an application you are developing is
    somehow unintuitive, slow and cumbersome, especially when compared
    to implementing the solution on Windows (Ex: Windows Visual Studio
    and C#)

-   Scalability on different devices or compatibility is often a problem
    and a challenge to solve

-   Powerful PC needed in order for the developing environment to run,
    especially if you cannot test it on an Android device and must
    emulate it

# Final conclusions

The conclusion is that, for a smaller scale of usage, Google’s Firebase
represents the best solution for persisting the data (authentication
info, messages in text format and not only) and communicating in
real-time. It is undoubtedly at least a better solution than persisting
the data locally, which will only make communication possible on the
same device. There is of course the option of sending the database after
each message between users with the help of internet, but it would be a
very significant technical slowdown. As stated before, Firebase provides
a fairly easy to implement solution (as opposed to the hardships of
implementing a real-time database yourself) that is heavily documented
across the internet by Google itself or by partners or simply by users
across the globe. It is also free of charge, unless of course you want
extend your applications in what concerns capacity or making it
commercially available to a large of array of clients across the globe
(there are pay plans for enabling the everyday programmer to do so)

# 5 Bibliography

Bates, Kathy Sierra & Bert. 2005. *Head First Java - 2nd Edition.* Salt
Lake City: Shroff/O’Reilly.2019. *dev.to.* 8 6. Accessed 11 24, 2019.
https://dev.to/tvanblargan/getting-started-with-firebase-authentication-2bg7.2012.
"Excerpt from "The Busy Coder's Guide to Android Development" ."
*commonsware.com.* Accessed 11 20, 2019.
https://commonsware.com/Android/excerpt.pdf.Google Comapny. n.d.
*firebase.google.com.* Accessed 11 12, 2019.
https://firebase.google.com/docs/database/.Joe. 2014. *JavaPapers.com.*
7 25. Accessed 1 3, 2020.
https://javapapers.com/android/android-chat-bubble/.Moroney, Laurence.
2017. *The Definitive Guide to Firebase: Build Android Apps on Google's
Mobile Platform.* Apress.Oracle America. 2015. *The Java Language
Specification .* Redwood City.POCATILU, Paul. 2012. *Programarea
dispozitivelor mobile.* Bucuresti: Editura ASE, Bucuresti,.S, Ashok
Kumar. 2018. *Mastering Firebase for Android Development.* Packt
Publishing.SATISH, RAM. 2015. *JavaArticles.com.* 4 22. Accessed 1 2,
2020.
https://www.javarticles.com/2015/04/android-sqlite-example.html.2018.
*Smashingmagazine.com.* 21 12. Accessed 11 1, 2019.
https://www.smashingmagazine.com/2018/02/comprehensive-guide-to-mobile-app-design/.Smyth,
Neil. 2019. *Android Studio 3.5 Development Essentials - Java Edition.*
Payload Media.Zapata, Belén Cruz. 2016. *Android Studio 2 Essentials -
Second Edition.* Packt Publishing.
