package fr.slvn.wipedata;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wipeData(View view) {
        DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        ComponentName componentName = new ComponentName(this, DeviceAdminReceiver.class);
        if (dpm.isAdminActive(componentName)) {
            dpm.wipeData(0);
        } else {
            Toast.makeText(this, "Not an active admin", Toast.LENGTH_SHORT).show();
        }
    }
}
