package com.abdul.pictures.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Blob;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(columnDefinition = "OID", nullable = false)
    private byte[] content;
    @ColumnDefault("NOW()")
    @Column(name = "created_at", nullable = false)
    private LocalDate createAt = LocalDate.now();

    public Photo(byte[] content) {
        this.content = content;
    }
}
