package tonpere.tamerecestjava;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {

    Image test;
    SpriteBatch batch;

    @Override
    public void show()
    {
        batch = new SpriteBatch();
        test = new Image(64, 64, new Texture(2, 2, null));
    }

    private void Update()
    {

    }

    @Override
    public void render(float delta) {
        this.Update();

        batch.begin();
        test.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        if(width <= 0 || height <= 0) return;
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}