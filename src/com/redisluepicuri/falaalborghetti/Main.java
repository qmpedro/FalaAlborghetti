package com.redisluepicuri.falaalborghetti;

import com.redisluepicuri.falaalborghetti.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

private AlertDialog alerta;
public MediaPlayer player;
public String[] ArrTitulos = {"Eu to louco?",
		"Vagabunda",
		"Peidou pra muzenga",
		"Oh, cara burro",
		"Todo dia tem uma merda",
		"Maior putaria",
		"Gazela do satanás",
		"Presta atenção",
		"Idiotas",
		"Puto da cara",
		"Vá a merda",
		"Falsos poetas",
		"Felipe",
		"Gostou",
		"Calem a boca",
		"Computador ta uma merda",
		"Vá a merda - 2",
		"Putaria, putaria",
		"Comunismo já acabou",
		"Cortar essa porra dessa piça",
		"E o cunete?",
		"Faz aqui um boquete",
		"Ééééé",
		"Pentelho de saco de cadáver",
		"Morro que nem um viado",
		"Fita no Blockbuster",
		"Enfia o dedo no meu rabo",
		"Carro da volskwagen",
		"Pastor mandou",
		"Cade meu pau?",
		"Galera do Slayer",
		"Se não gostou, oda-se",
		"Merda desse programa",
		"Dou a bunda em pç pública",
		"Ninguém trepa",
		"Quem é honesto",
		"Eu não concordo",
		"Amante da tua mãe",
		"Espanador na bunda",
		"A... a... a... aaaaAA..."};

	public class MyAdapter extends BaseAdapter {
		   
		  final int NumberOfItem = ArrTitulos.length;
		  private Bitmap[] bitmap = new Bitmap[NumberOfItem];
		   
		  private Context context;
		  private LayoutInflater layoutInflater;
		   
		  MyAdapter(Context c){
		   context = c;
		   layoutInflater = LayoutInflater.from(context);
		    
		   // Init dummy bitmap, using R.drawable.icon for all items
		   for(int i = 0; i < NumberOfItem; i++){
		    bitmap[i] = BitmapFactory.decodeResource(context.getResources(), R.drawable.botao);
		   }
		  }
		 
		  @Override
		  public int getCount() {
		   // TODO Auto-generated method stub
		   return bitmap.length;
		  }
		 
		  @Override
		  public Object getItem(int position) {
		   // TODO Auto-generated method stub
		   return bitmap[position];
		  }
		 
		  @Override
		  public long getItemId(int position) {
		   // TODO Auto-generated method stub
		   return position;
		  }
		 
		  @Override
		  public View getView(int position, View convertView, ViewGroup parent) {
		   // TODO Auto-generated method stub
		    
		   View grid;
		   if(convertView==null){
		    grid = new View(context);
		    grid = layoutInflater.inflate(R.layout.gridlayout, parent, false); 
		   }else{
		    grid = (View)convertView; 
		   }
		    
		   ImageView imageView = (ImageView)grid.findViewById(R.id.image);
		   imageView.setImageBitmap(bitmap[position]);
		   TextView textView = (TextView)grid.findViewById(R.id.text);
		   textView.setText(ArrTitulos[position].toString());
		   Typeface font = Typeface.createFromAsset(getAssets(), "RobotoCondensed-Bold.ttf");  
		   textView.setTypeface(font);
		   
		   return grid;
		  }
		 
	}
		 
 	GridView gridView;
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView = (GridView)findViewById(R.id.grid);
 
        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);
        
        player = new MediaPlayer();
        
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
 
	        	try{ 	        		
	        		if(player.isPlaying())
	        			player.stop();
	        		player = getSom(position);
	                player.start();          		
	            }
	            catch (Exception e) {
	            	Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();                	                	
	    		}
        	
        	}
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(Menu.NONE, 1, Menu.NONE, "Sair");
        menu.add(Menu.NONE, 2, Menu.NONE, "Redislú & Picurí");
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        switch (item.getItemId())
		{
			case 1:
				finish();
                break;
	
            case 2:
            	alertasobre_layout();
                break;
	    }
        return (super.onOptionsItemSelected(item));
    }
    
	private void alertasobre_layout() {
		LayoutInflater li = getLayoutInflater();
		View view = li.inflate(R.layout.alertasobre, null);
		view.findViewById(R.id.btOk).setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View arg0) {
						alerta.dismiss();
					}
				});
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(view);
		alerta = builder.create();
		alerta.show();
	}
    
    private MediaPlayer getSom(int posicao)
    {
    	MediaPlayer pl = new MediaPlayer();
    	switch (posicao) {
    	case 0:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x0)	;
    	    break;
    	    
    	case 1:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x1);    	    
    		break;
    		
    	case 2:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x2);    	    
    		break;
    		
    	case 3:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x3);    	    
    		break;
    		
    	case 4:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x4);    	    
    		break;
    		
    	case 5:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x5);    	    
    		break;
    		
    	case 6:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x6);    	    
    		break;
    		
    	case 7:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x7);    	    
    		break;
    		
    	case 8:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x8);    	    
    		break;
    		
    	case 9:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x9);    	    
    		break;
    		
    	case 10:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x10);    	    
    		break;
    		
    	case 11:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x11);    	    
    		break;
    		
    	case 12:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x12);    	    
    		break;
    		
    	case 13:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x13);    	    
    		break;
    		
    	case 14:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x14);    	    
    		break;
    		
    	case 15:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x15);    	    
    		break;
    		
    	case 16:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x16);    	    
    		break;
    		
    	case 17:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x17);    	    
    		break;
    		
    	case 18:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x18);    	    
    		break;
    		
    	case 19:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x19);    	    
    		break;
    		
    	case 20:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x20);    	    
    		break;
    		
    	case 21:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x21);    	    
    		break;
    		
    	case 22:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x22);    	    
    		break;
    		
    	case 23:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x23);    	    
    		break;
    		
    	case 24:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x24);    	    
    		break;
    		
    	case 25:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x25);    	    
    		break;
    		
    	case 26:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x26);    	    
    		break;
    		
    	case 27:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x27);    	    
    		break;
    		
    	case 28:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x28);    	    
    		break;
    		
    	case 29:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x29);    	    
    		break;
    		
    	case 30:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x30);    	    
    		break;
    		
    	case 31:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x31);    	    
    		break;
    		
    	case 32:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x32);    	    
    		break;
    		
    	case 33:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x33);    	    
    		break;
    		
    	case 34:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x34);    	    
    		break;
    		
    	case 35:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x35);    	    
    		break;
    		
    	case 36:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x36);    	    
    		break;
    		
    	case 37:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x37);    	    
    		break;
    		
    	case 38:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x38);    	    
    		break;
    		
    	case 39:
    		pl = MediaPlayer.create(getApplicationContext(), R.raw.x39);    	    
    		break;
    	    
	    default:
	    	pl = MediaPlayer.create(getApplicationContext(), R.raw.x0);
    	}
    	
    	return pl;
    }    
}
