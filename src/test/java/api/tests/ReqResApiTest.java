package api.tests;

import api.client.ReqResClient;
import api.dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class ReqResApiTest {
    ReqResClient client = new ReqResClient();

    @Test(priority = 1)
    public void shouldCreateUserSuccessfully() {
        UserDTO createdUser = client.createUser("Facundo", "QA Automation");

        //Verificaciones generales
        Assert.assertEquals(createdUser.getName(), "Facundo");
        Assert.assertEquals(createdUser.getJob(), "QA Automation");

        //Verificaciones sobre el ID
        Assert.assertNotNull(createdUser.getId(), "ID no debería ser nulo");
        Assert.assertTrue(createdUser.getId().matches("\\d+"), "ID debe estar constituído solo por números");
        Assert.assertFalse(createdUser.getId().isBlank(), "ID no debería estar vacío");

        //Verificaciones sobre la fecha de creación
        Assert.assertTrue(createdUser.getCreatedAt().startsWith(LocalDate.now().toString()), "El usuario debería haberse creado hoy");
        Assert.assertTrue(createdUser.getCreatedAt().matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.*"),
                "La fecha de creación debe tener un formato ISO-8601");

        System.out.println(createdUser.getCreationData());
    }

    @Test(priority = 2)
    public void shouldGetUserSuccessfully() {
        UserDTO user = client.getUserById("2");

        //Verificaciones generales
        Assert.assertNotNull(user, "La respuesta obtenida no debería ser nula");
        Assert.assertNotNull(user.getFirstName(), "El nombre del usuario no debería ser nulo");
        Assert.assertNotNull(user.getLastName(), "El apellido del usuario no debería ser nulo");

        //Verificaciones sobre el ID
        Assert.assertNotNull(user.getId(), "El ID del usuario no debería ser nula");
        Assert.assertTrue(user.getId().matches("\\d+"), "ID debe estar constituído solo por números");

        System.out.println(user.getUserData());
    }
}