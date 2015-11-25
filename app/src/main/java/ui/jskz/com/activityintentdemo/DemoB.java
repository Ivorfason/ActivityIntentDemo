package ui.jskz.com.activityintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class DemoB extends Activity implements View.OnClickListener {
    private Button mABtn;
    private Button mBBtn;
    private Button mCBtn;
    private EditText mCET;
    private EditText mDET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_b);
        initView();
        initListener();
    }

    private void initView() {
        this.mABtn = (Button) findViewById(R.id.mi_two1_btn);
        this.mBBtn = (Button) findViewById(R.id.mi_two4_btn);
        this.mCBtn = (Button) findViewById(R.id.mi_two5_btn);
        this.mCET = (EditText) findViewById(R.id.mi_two2_et);
        this.mDET = (EditText) findViewById(R.id.mi_two3_et);
    }

    private void initListener() {
        mABtn.setOnClickListener(this);
        mBBtn.setOnClickListener(this);
        mCBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mi_two1_btn:
                Bundle bundle = this.getIntent().getExtras();
                String name = bundle.getString("name");
                mABtn.setText(name);
                break;
            case R.id.mi_two4_btn:
                Intent i2 = new Intent();
                i2.putExtra("firstname", mCET.getText().toString());
                i2.putExtra("secondname", mDET.getText().toString());
                DemoB.this.setResult(1, i2);
                DemoB.this.finish();
                break;
            case R.id.mi_two5_btn:
                ArrayList<String> listB = new ArrayList<>();
                listB = getIntent().getStringArrayListExtra("List");
                mCBtn.setText(listB.get(0).toString());
                break;
        }
    }
}
