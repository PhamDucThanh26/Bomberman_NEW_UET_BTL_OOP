package com.carlosflorencio.bomberman.entities.bomb;

import com.carlosflorencio.bomberman.Board;
import com.carlosflorencio.bomberman.entities.AnimatedEntitiy;
import com.carlosflorencio.bomberman.entities.Entity;
import com.carlosflorencio.bomberman.entities.mob.Mob;
import com.carlosflorencio.bomberman.graphics.Screen;
import com.carlosflorencio.bomberman.graphics.Sprite;


public class Explosion extends AnimatedEntitiy {

	protected boolean _last = false;
	protected Board _board;
	protected int direction;
	protected Sprite _sprite1, _sprite2;
	
	public Explosion(int x, int y, int _direction, boolean last, Board board) {
		_x = x;
		_y = y;
		_last = last;
		_board = board;
		direction = _direction;
		switch (direction) {
			case 0:
				if(last == false) {
					_sprite = Sprite.movingSprite(Sprite.explosion_vertical1,
							Sprite.explosion_vertical2,Sprite.explosion_vertical,_animate,15);
				} else {
					_sprite = Sprite.movingSprite(Sprite.explosion_vertical_top_last1,
							Sprite.explosion_vertical_top_last2,
							Sprite.explosion_vertical_top_last,_animate,15);
				}
			break;
			case 1:
				if(!last) {
					_sprite = Sprite.movingSprite(Sprite.explosion_horizontal1,
							Sprite.explosion_horizontal2,
							Sprite.explosion_horizontal, _animate, 15);
				} else {
					_sprite = Sprite.movingSprite(Sprite.explosion_horizontal_right_last1,
							Sprite.explosion_horizontal_right_last2,
							Sprite.explosion_horizontal_right_last,_animate,15);
				}
				break;
			case 2:
				if(!last) {
					_sprite = Sprite.explosion_vertical2;
				} else {
					_sprite = Sprite.explosion_vertical_down_last2;
				}
				break;
			case 3: 
				if(!last) {
					_sprite = Sprite.explosion_horizontal2;
				} else {
					_sprite = Sprite.explosion_horizontal_left_last2;
				}
				break;
		}
	}
	
	@Override
	public void render(Screen screen) {
		int xt = (int)_x << 4;
		int yt = (int)_y << 4;
		update();
		screen.renderEntity(xt, yt , this);
	}
	
	@Override
	public void update() {
		if(direction == 0) {
				if(!_last) {
					_sprite = Sprite.movingSprite(Sprite.explosion_vertical2,
							Sprite.explosion_vertical1,Sprite.explosion_vertical,_animate,100);
				} else {
					_sprite = Sprite.movingSprite(Sprite.explosion_vertical_top_last2,
							Sprite.explosion_vertical_top_last1,
							Sprite.explosion_vertical_top_last,_animate,100);
				}
		}
		else if(direction == 1) {
			System.out.println("update");
			if(!_last) {
				_sprite = Sprite.movingSprite(Sprite.explosion_horizontal2,
						Sprite.explosion_horizontal1,
						Sprite.explosion_horizontal, _animate, 100);
			} else {
				_sprite = Sprite.movingSprite(Sprite.explosion_horizontal_right_last2,
						Sprite.explosion_horizontal_right_last1,
						Sprite.explosion_horizontal_right_last,_animate,
						100);
			}
		}
		else if(direction == 2) {
			if(!_last) {
				_sprite = Sprite.movingSprite(Sprite.explosion_vertical2,
						Sprite.explosion_vertical1,
						Sprite.explosion_vertical, _animate, 100);
			} else {
				_sprite = Sprite.movingSprite(Sprite.explosion_vertical_down_last2,
						Sprite.explosion_vertical_down_last1,
						Sprite.explosion_vertical_down_last,_animate, 100);
			}
		}
		else {
			if(!_last) {
				_sprite = Sprite.movingSprite(Sprite.explosion_horizontal2,
						Sprite.explosion_horizontal1,
						Sprite.explosion_horizontal, _animate, 100);
			} else {
				_sprite = Sprite.movingSprite(Sprite.explosion_horizontal_left_last2,
						Sprite.explosion_horizontal_left_last1,
						Sprite.explosion_horizontal_left_last,_animate,
						100);
			}
		}



		animate();
	}

	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Mob) {
			((Mob)e).kill();
		}
		
		return true;
	}
}