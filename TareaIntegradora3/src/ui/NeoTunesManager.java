/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ui;

import java.util.Scanner;
import model.NeoTunesController;

/**
 *
 * @author DANIELA LONDOÑO
 */
public class NeoTunesManager {

    public Scanner reader;
    public NeoTunesController controller;

    public NeoTunesManager() {
        this.reader = new Scanner(System.in);
        this.controller = new NeoTunesController();
    }

    /**
     * Description: show the menu of system
     */
    public void showMainMenu() {

        System.out.println("Welcome to NeoTunes");

        boolean stopFlag = false;

        while (!stopFlag) {

            System.out.println("\nType an option");
            System.out.println("1. Register a producer user");
            System.out.println("2. Register a consumer user");
            System.out.println("3. Register an audio");
            System.out.println("4. Create a playlist");
            System.out.println("5. Edit a playlist");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();

            switch (mainOption) {

                case 1:
                    registerProducer();
                    break;
                case 2:
                    registerConsumer();
                    break;
                case 3:
                    registerAudio();
                    break;
                case 4:
                    createPlaylist();
                    break;
                case 5:
                    editPlaylist();
                    break;
                case 0:
                    System.out.println("Thanks for using our system");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("You must type a valid option");
                    break;

            }

        }

    }

    /**
     * Description: Register a consumer user. For them it shows the two types of
     * consumer that exist and registers the one that the user wants
     */
    public void registerConsumer() {
        System.out.print("Register consumer user");
        System.out.println("\n1.Register standard\n2.Register premium");
        int option = reader.nextInt();
        while (option > 2 || option <= 0) {
            System.out.println("\nType the option well: \n1.Register standard\n2.Register premium");
            option = reader.nextInt();
        }
        System.out.println("Enter a name");
        reader.nextLine();
        String name = reader.nextLine();

        System.out.println("Enter a id");
        String id = reader.nextLine();

        if (controller.registerConsumer(name, id, option)) {
            System.out.println("User registerd");
        } else {
            System.out.println("Could not register user");
        }
    }

    /**
     * Description: Register a producer user. For them it shows the two types of
     * producer that exist and registers the one that the user wants
     */
    public void registerProducer() {
        System.out.print("Register producer user");
        System.out.println("\n1.Register artist\n2.Register content creator ");
        int option = reader.nextInt();
        while (option > 2 || option <= 0) {
            System.out.println("\nType the option well: \n1.Register standard\n2.Register premium");
            option = reader.nextInt();
        }
        System.out.println("Enter a name");
        reader.nextLine();
        String name = reader.nextLine();

        System.out.println("Enter a id");
        String id = reader.nextLine();

        System.out.println("Enter a URL");
        String url = reader.nextLine();

        if (controller.registerProducer(url, name, id, option)) {
            System.out.println("User registerd");
        } else {
            System.out.println("Could not register user");
        }
    }

    /**
     * Description: Register a audio. For them it shows the two types of audios
     * that exist and registers the one that the user wants
     */
    public void registerAudio() {
        System.out.print("Register producer user");
        System.out.println("\n1.Register song\n2.Register poscast ");
        int option = reader.nextInt();
        while (option > 2 || option <= 0) {
            System.out.println("\nType the option well: \n1.Register song\n2.Register poscast");
            option = reader.nextInt();
        }
        System.out.println("Enter the name");
        reader.nextLine();
        String name = reader.nextLine();
        System.out.println("Enter the url of the image");
        String url = reader.nextLine();
        System.out.println("Ente the duration");
        double duration = reader.nextDouble();

        if (option == 1) {
            System.out.println("Enter the album");
            reader.nextLine();
            String album = reader.nextLine();
            System.out.println("Enter the sale value");
            double valueSale = reader.nextDouble();
            System.out.println("Choose the gener(index)");
            System.out.println(controller.toStringGener());
            int index = reader.nextInt();
            if (controller.registerSong(album, valueSale, index, name, url, duration)) {
                System.out.println("Song registerd");
            } else {
                System.out.println("could not register song");
            }
        } else {
            System.out.println("Enter the description");
            reader.nextLine();
            String description = reader.nextLine();
            System.out.println("Choose the category(index)");
            System.out.println(controller.toStringCategory());
            int index = reader.nextInt();
            if (controller.registerPodcast(description, index, name, url, duration)) {
                System.out.println("Poscast registerd");
            } else {
                System.out.println("could not register poscast");
            }
        }

    }

    /**
     *  Descrption: Create a playlist for a user
     */
    public void createPlaylist() {
        System.out.println("These are the registered users");
        System.out.println(controller.showUser());
        System.out.println("Enter the position of the user you want to add the playlist to");
        int index = reader.nextInt();
        System.out.println("Enter the name of the playlist");
        reader.nextLine();
        String name = reader.nextLine();

        if (controller.registerPlaylist(name, index)) {
            System.out.println("Playlist registerd");
        } else {
            System.out.println("could not register playlist");
        }

    }

    /**
     *Description: Edit a user's playlist, this includes renaming a playlist, adding and removing audio from a playlist
     */
    public void editPlaylist() {
        System.out.println("These are the registered users");
        System.out.println(controller.showUser());
        System.out.println("Enter the position of the user");
        int indexUser = reader.nextInt();
        System.out.println("These are the playlists of user: " + controller.getUsers().get(indexUser).getNickName());
        System.out.println(controller.showPlaylistOfUser(indexUser));
        System.out.println("Enter the position of the playlist");
        int indexPlaylist = reader.nextInt();

        System.out.println("Edit menu\n1.Rename playlist\n2.Add audio to playlist\n3.Delete audio to playlist");
        int option = reader.nextInt();

        if (option == 1) {
            System.out.println("New playlist name");
            reader.nextLine();
            String name = reader.nextLine();
            if (controller.editNameofPlaylist(indexPlaylist, name , indexUser)) {
                System.out.println("The name was changed successfully");
            } else {
                System.out.println("The name could not be changed");
            }
        } else {
            if (option == 2) {
                System.out.println("what want add\n1.Poscast\n2.Song");
                int opt = reader.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println(controller.showAudios(2));
                        break;
                    case 2:
                        System.out.println(controller.showAudios(3));
                        break;
                    default:
                        break;
                }
                System.out.println("Enter the position of the audio");
                int indexAudio = reader.nextInt();

                if (controller.editPlaylist(indexPlaylist, indexAudio, indexUser, 1)) {
                    System.out.println("Added audio");
                } else {
                    System.out.println("Audio not added");
                }
            } else {
                if (option == 3) {
                    System.out.println("what do you want to delete\n1.Poscast\n2.Song");
                    int opt3 = reader.nextInt();
                    switch (opt3) {
                        case 1:
                            System.out.println(controller.showAudiosPlaylist(2, indexPlaylist, indexUser));
                            break;
                        case 2:
                            System.out.println(controller.showAudiosPlaylist(3, indexPlaylist, indexUser));
                            break;
                        default:
                            break;
                    }
                    System.out.println("Enter the position of the audio");
                    int indexAudio3 = reader.nextInt();
                    if (controller.editPlaylist(indexPlaylist, indexAudio3, indexUser, 2)) {
                        System.out.println("Deleted audio");
                    } else {
                        System.out.println("Audio not deleted");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NeoTunesManager neoTunes = new NeoTunesManager();
        neoTunes.showMainMenu();
    }
}
