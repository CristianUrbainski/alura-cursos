package br.com.alura.technews.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.technews.database.dao.NoticiaDAO
import br.com.alura.technews.model.Noticia

const val NOME_BANCO_DE_DADOS = "news.db"

@Database(entities = [Noticia::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val noticiaDAO: NoticiaDAO

    companion object {

        private lateinit var database: AppDatabase

        fun getInstance(context: Context): AppDatabase {

            if (::database.isInitialized) return database

            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                NOME_BANCO_DE_DADOS
            ).build()

            return database
        }

    }

}