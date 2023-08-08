package com.education.onlinecampus.service.common.impl;

import com.education.onlinecampus.data.dto.*;
import com.education.onlinecampus.data.entity.*;
import com.education.onlinecampus.data.mapper.*;
import com.education.onlinecampus.data.marker.*;
import com.education.onlinecampus.repository.*;
import com.education.onlinecampus.repository.lecture.MemberRepository;
import com.education.onlinecampus.repository.manager.CourseChapterRepository;
import com.education.onlinecampus.repository.manager.CourseRepository;
import com.education.onlinecampus.service.common.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {
    private final FileRepository fileRepository;
    private final MemberRepository memberRepository;
    private final CourseRepository courseRepository;
    private final CourseChapterRepository courseChapterRepository;

    @Override public FileRepository getFileRepository() {return fileRepository;}
    @Override public MemberRepository getMemberRepository(){return memberRepository;}
    @Override public CourseRepository getCourseRepository(){return courseRepository;}
    @Override public CourseChapterRepository getCourseChapterRepository(){return courseChapterRepository;}
    @Override
    public <E extends EntityMarker, T extends DTOMarker> E convertDTOToEntity(T dto) {
        if (dto instanceof CommonCodeDTO)
            return (E) CommonCodeMapper.INSTANCE.toEntity((CommonCodeDTO) dto);
        if (dto instanceof FileDTO)
            return (E) FileMapper.INSTANCE.toEntity((FileDTO) dto);
        if (dto instanceof MemberDTO)
            return (E) MemberMapper.INSTANCE.toEntity((MemberDTO) dto);
        return null;
    }
    @Override
    public <E extends EntityMarker, T extends DTOMarker> T convertEntityToDTO(E entity) {
        if (entity instanceof CommonCode)
            return (T) CommonCodeMapper.INSTANCE.toDTO((CommonCode) entity);
        if (entity instanceof File)
            return (T) FileMapper.INSTANCE.toDTO((File) entity);
        if (entity instanceof Member)
            return (T) MemberMapper.INSTANCE.toDTO((Member) entity);
        return null;
    }
}
