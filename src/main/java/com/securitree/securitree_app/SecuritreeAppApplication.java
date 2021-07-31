package com.securitree.securitree_app;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.securitree.securitree_app.model.AccessRule;
import com.securitree.securitree_app.model.Area;
import com.securitree.securitree_app.model.Door;
import com.securitree.securitree_app.model.User;
import com.securitree.securitree_app.repositories.DoorRepository;
import com.securitree.securitree_app.services.WriteToDatabaseService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecuritreeAppApplication {

    private final DoorRepository doorRepository;

    public SecuritreeAppApplication(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecuritreeAppApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(WriteToDatabaseService securiUserService) {

//  Read both your registered users and system data json files and write to the database
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, DeserializationFeature.EAGER_DESERIALIZER_FETCH);
            TypeReference<List<User>> userReference = new TypeReference<List<User>>() {
            };
            TypeReference<List<AccessRule>> accessReference = new TypeReference<List<AccessRule>>() {
            };
            TypeReference<List<Area>> areaReference = new TypeReference<List<Area>>() {
            };
            TypeReference<List<Door>> doorsReference = new TypeReference<List<Door>>() {
            };
            InputStream inputStreamUsers = TypeReference.class.getResourceAsStream("/json/users.json");
            InputStream inputStreamAccessRules = TypeReference.class.getResourceAsStream("/json/access_rules_list.json");
            InputStream inputStreamAreas = TypeReference.class.getResourceAsStream("/json/area_list.json");
            InputStream inputStreamDoors = TypeReference.class.getResourceAsStream("/json/doors.json");
            try {
                List<User> users = mapper.readValue(inputStreamUsers, userReference);
                List<AccessRule> rules = mapper.readValue(inputStreamAccessRules, accessReference);
                List<Area> areas = mapper.readValue(inputStreamAreas, areaReference);
                List<Door> Alldoors = mapper.readValue(inputStreamDoors, doorsReference);
                securiUserService.writeUsers(users);
                securiUserService.writeAreas(areas);
                securiUserService.writeDoors(Alldoors);
                securiUserService.writeRules(rules);

            } catch (IOException io) {
            }

        };
    }

}
