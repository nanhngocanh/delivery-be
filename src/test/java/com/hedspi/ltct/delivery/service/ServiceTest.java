package com.hedspi.ltct.delivery.service;

import com.hedspi.ltct.delivery.entity.Status;
import com.hedspi.ltct.delivery.repository.StatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    StatusRepository statusRepository;
    @InjectMocks
    StatusService statusService;

    @Test
    public void testGetAll(){
        List<Status> mockStatusList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            mockStatusList.add(new Status(i,"stt-"+i));
        }
        when(statusRepository.findAll()).thenReturn(mockStatusList);
        List<Status> actualStatus = statusService.getAll();

        assertThat(actualStatus.size()).isEqualTo(mockStatusList.size());

        verify(statusRepository).findAll();
    }

    @Test
    void whenGetInvalidOne_shouldThrowException() {
        Integer invalidStatusId = 7;

        when(statusRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

        assertThatThrownBy(() -> statusService.getOne(invalidStatusId))
                .isInstanceOf(ChangeSetPersister.NotFoundException.class);

        verify(statusRepository).findById(any(Integer.class));
    }


}

