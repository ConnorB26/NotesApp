package com.connorb26.notesapp.di

import android.app.Application
import androidx.room.Room
import com.connorb26.notesapp.feature_note.data.data_source.NoteDatabase
import com.connorb26.notesapp.feature_note.data.repository.NoteRepositoryImpl
import com.connorb26.notesapp.feature_note.domain.repository.NoteRepository
import com.connorb26.notesapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }

    @Provides
    @Singleton
    fun provideCalendarUseCases(): CalendarUseCases {
        return CalendarUseCases(
            getEventsDay = GetEventsDay(),
            getEventsRange = GetEventsRange(),
            addEvent = AddEvent(),
            addHW = AddHW(),
            editEvent = EditEvent()
        )
    }
}