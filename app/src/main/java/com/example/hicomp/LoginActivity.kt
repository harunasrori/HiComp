package com.example.hicomp


import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    //Google Login Request Code
    private val RC_SIGN_IN = 7
    //Google Sign In Client
    private lateinit var GoogleSignInClient: GoogleSignInClient
    //Firebase Auth
    private lateinit var Auth: FirebaseAuth

    private lateinit var btn_login : Button
    private lateinit var btn_loginGoogle : Button
    private lateinit var etUsername : EditText
    private lateinit var etPass : EditText
    private lateinit var btn_toRegist : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        GoogleSignInClient = GoogleSignIn.getClient(this, gso)
        Auth = Firebase.auth

        btn_login = findViewById(R.id.btn_login)
        btn_loginGoogle = findViewById(R.id.btn_loginGoogle)
        btn_toRegist = findViewById(R.id.toRegist)

        btn_login.setOnClickListener(this)
        btn_toRegist.setOnClickListener(this)
        btn_loginGoogle.setOnClickListener({
            signIn()
        })
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        Auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = Auth.currentUser
                    updateUI(user)
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = Auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(user: FirebaseUser?){
        if(user != null){
            //Do your Stuff
            Toast.makeText(this,"Hello ${user.displayName}",Toast.LENGTH_LONG).show()
        }
    }

    private fun signIn() {
        val signInIntent = GoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.btn_login -> run {
                    val intentbiasa = Intent(this@LoginActivity, HomePage::class.java)
                    startActivity(intentbiasa)
                }
                R.id.toRegist -> run {
                    val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
                    startActivity(intent)
                }
            }
        }


    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
    }

