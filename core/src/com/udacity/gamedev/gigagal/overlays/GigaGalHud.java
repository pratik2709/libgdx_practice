package com.udacity.gamedev.gigagal.overlays;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.udacity.gamedev.gigagal.util.Assets;
import com.udacity.gamedev.gigagal.util.Constants;
import com.udacity.gamedev.gigagal.util.Util;

public class GigaGalHud {
    public final Viewport viewport;
    final BitmapFont font;

    public GigaGalHud(){
        viewport = new ExtendViewport(Constants.HUD_VIEWPORT_SIZE, Constants.HUD_VIEWPORT_SIZE);
        font = new BitmapFont();
    }

    public void render(SpriteBatch batch, int lives, int ammo, int score){
        //??
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        final String hudString =
                Constants.HUD_SCORE_LABEL + score + "\n" +
                        Constants.HUD_AMMO_LABEL + ammo;
        font.draw(batch, hudString,
                Constants.HUD_MARGIN,
                viewport.getWorldHeight() - Constants.HUD_MARGIN);
        final TextureRegion standingRight = Assets.instance.gigaGalAssets.standingRight;
        for(int i = 0; i < lives; i++){
            Util.drawTextureRegion(batch,
                    standingRight,
                    new Vector2(
                            viewport.getWorldWidth() - i*( Constants.HUD_MARGIN/2 +
                                    standingRight.getRegionWidth()),
                            viewport.getWorldHeight() - Constants.HUD_MARGIN
                    - standingRight.getRegionHeight()),
                    Constants.GIGAGAL_EYE_POSITION);
        }
        batch.end();
    }
}
