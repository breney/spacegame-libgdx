package pt.uma.arq.game;

import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.Ship;

import java.util.ArrayList;
import java.util.Iterator;

public class LaserManagement {

    private static ArrayList<Ship> ship = new ArrayList<>();

    private static ArrayList<Laser> laserArrayList = new ArrayList<>();

    private static PlayerShip playerShip;

    //função adicionar laser ao array
    public static void add(Laser laser) {
        laserArrayList.add(laser);
    }

    //função para remover laser do array apos ter sido disparado
    public static void remove() {

        Iterator<Laser> it = laserArrayList.iterator();

        while (it.hasNext()) {
            Laser laser = it.next();
            if (laser.isRemovable()) {
                it.remove();
            }
            if (laser.isPlayerLaser() == true && laser.isColidedEnemyShip(ship,playerShip)) {
                it.remove();
            }
            if (laser.isPlayerLaser() == false && laser.isColidedPlayerShip(playerShip)) {
                it.remove();
            }
        }

    }

    //função para renderizar lasers dentro array
    public static void render() {
        for (Laser laser : laserArrayList) {
            laser.render();
        }
    }

    //função para atualizar cordenadas das naves enimigas
    public static void updateEnemyShipPosition(ArrayList<Ship> ships) {
        ship = ships;
    }
    //função para atualizar cordenadas do player
    public static void updatePlayerShipPosition(PlayerShip ship) {
        playerShip = ship;
    }


}
