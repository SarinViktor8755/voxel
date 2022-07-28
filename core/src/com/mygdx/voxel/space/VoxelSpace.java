package com.mygdx.voxel.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class VoxelSpace extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture color_map;
	Texture vertax_map;

	Pixmap pm;

	Color color_temp;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		color_map = new Texture("maps/C1W.png");
		vertax_map = new Texture("maps/D1.png");

		color_map.getTextureData().prepare();

		pm = new Pixmap(color_map.getTextureData().consumePixmap().getPixels());
		color_temp = new Color();
	}

	@Override
	public void render () {

		//color_temp.set(pm.getPixel(1,1));


		ScreenUtils.clear(color_temp);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
