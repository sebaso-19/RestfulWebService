package com.mycompany.serviciosrestful;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/persona")
public class PersonaResource {
    private List<Persona> personas;

    public PersonaResource() {
        initialize(); // Inicializar la lista de personas
    }

    private void initialize() {
        personas = new ArrayList<>();
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Maria", 30));
        personas.add(new Persona("Carlos", 40));
        personas.add(new Persona("Ana", 35));
        personas.add(new Persona("Luis", 28));
    }

    @GET
    @Path("/salarioPromedio")
    @Produces(MediaType.APPLICATION_XML)
    public double getSalarioPromedio() {
        double salarioTotal = 0;
        int contador = 0;

        for (Persona persona : personas) {
            salarioTotal += persona.getSalario();
            contador++;
        }

        return salarioTotal / contador;
    }

    @GET
    @Path("/sumaSalarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSumaSalarios() {
        double salarioTotal = 0;

        for (Persona persona : personas) {
            salarioTotal += persona.getSalario();
        }

        return Response.ok("{\"sumaSalarios\": " + salarioTotal + "}").build();
    }
}