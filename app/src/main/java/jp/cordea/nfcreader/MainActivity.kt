package jp.cordea.nfcreader

import android.nfc.NfcAdapter
import android.nfc.tech.NfcA
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NfcAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = NfcAdapter.getDefaultAdapter(this)
    }

    override fun onResume() {
        super.onResume()
        adapter.enableReaderMode(
                this,
                {
                    val nfc = NfcA.get(it)
                },
                NfcAdapter.FLAG_READER_NFC_A or NfcAdapter.FLAG_READER_NFC_B,
                null
        )
    }

    override fun onPause() {
        super.onPause()
        adapter.disableReaderMode(this)
    }
}
