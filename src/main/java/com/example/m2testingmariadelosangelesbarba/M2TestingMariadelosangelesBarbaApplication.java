package com.example.m2testingmariadelosangelesbarba;

import com.example.m2testingmariadelosangelesbarba.entidades.Usuario;
import com.example.m2testingmariadelosangelesbarba.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.EmptyResultDataAccessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class M2TestingMariadelosangelesBarbaApplication implements CommandLineRunner {
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingMariadelosangelesBarbaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String cadena = "L";

		while (cadena.equals("I") || cadena.equals("L") || cadena.equals("BT")) {
			//Escribir por pantalla las opciones y leer por teclado
			System.out.println("¿Qué operación quieres realizar? Insertar(I)/Leer(L)/Borrar(B)/BorrarTodo(BT)");
			System.out.println("Para salir pulsa S");
			cadena = LeerporTeclado();
			if (cadena.equals("S"))
				System.exit(0);

			switch (cadena) {
				case "I":
					Usuario usuario1 = new Usuario(null, "Pedro Pérez", 23, "Las Palmas de Gran Canaria", "pedroperez@email.com", true);
					Usuario usuario2 = new Usuario(null, "Ariadna Artiles", 21, "Santa Cruz de Tenerife", "ariadnaartiles@email.com", false);

					usuarioRepositorio.save(usuario1);
					usuarioRepositorio.save(usuario2);
					System.out.println("Los nuevos clientes han sido guardados en la base de datos.");

					break;

				case "L":
					List<Usuario> usuarios = usuarioRepositorio.findAll();
					System.out.println(usuarios);
					System.out.println(usuarios.size());
					break;

				case "B":
					System.out.print("* Inserta el ID del usuario que quieres borrar:");
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br = new BufferedReader(isr);
					cadena = br.readLine();
					Long ident = Long.valueOf(cadena);
					try{
						usuarioRepositorio.deleteById(ident);
					} catch (EmptyResultDataAccessException e){
						e.printStackTrace();
					}
					System.out.println("Se ha borrado el usuario");
					cadena = "L";
					break;

				case "BT":
					System.out.println("¿Estás seguro de que quieres borrar todos los usuarios? YES/NOT");
					isr = new InputStreamReader(System.in);
					br = new BufferedReader(isr);
					String respuesta = br.readLine();
					if (respuesta.equals("YES") ){
					usuarioRepositorio.deleteAll();
					System.out.println("La tabla está vacía.");}
					break;
			}

		}
	}

	//Función para leer por teclado la operación a realizar
	public static String LeerporTeclado() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
}


