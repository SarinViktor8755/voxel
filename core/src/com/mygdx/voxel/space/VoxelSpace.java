package com.mygdx.voxel.space;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import org.graalvm.compiler.loop.MathUtil;

import java.nio.ByteBuffer;

public class VoxelSpace extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture color_map;
    Texture vertax_map;

    Pixmap pm;

    Color color_temp;

    int x, y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        color_map = new Texture("maps/C1W.png");
        vertax_map = new Texture("maps/D1.png");

        color_map.getTextureData().prepare();


//pm = new Pixmap(321,321, Pixmap.Format.RGB888);
//		pm = new Pixmap(color_map.getTextureData().consumePixmap().getPixels());

        color_temp = new Color();
        color_temp.set(color_map.getTextureData().consumePixmap().getPixel(1, 1));

    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.WHITE);

        batch.begin();
        color_map.getTextureData().prepare();
        ByteBuffer bb = color_map.getTextureData().consumePixmap().getPixels();


     //   for (int j = 0; j < color_map.getTextureData().getHeight(); j++)
            for (int i = 0; i < color_map.getTextureData().getHeight(); i++) {
                color_temp.set(bb.get(i));
               // System.out.println(color_temp);
                batch.setColor(color_temp);
                batch.draw(img, i, 1);
            }


        batch.end();


    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
