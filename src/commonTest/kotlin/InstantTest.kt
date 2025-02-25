import com.github.ricky12awesome.jss.JsonFormat
import com.github.ricky12awesome.jss.JsonSchema
import com.github.ricky12awesome.jss.encodeToSchema
import com.github.ricky12awesome.jss.myGlobalJson
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

class InstantTest {

    @Serializable
    public data class Event(
        @JsonSchema.Format(JsonFormat.dateTime)
        val createdAt: Instant,
    )

    @Test
    fun check_ProtectedString() {
        println(myGlobalJson.encodeToSchema(Event.serializer(), false,))
        assertEquals(
            myGlobalJson.encodeToSchema(Event.serializer(), false,), """
            {
              "${"$"}schema": "http://json-schema.org/draft-07/schema",
              "title": "InstantTest.Event",
              "additionalProperties": false,
              "type": "object",
              "properties": {
                "createdAt": {
                  "type": "string",
                  "format": "date-time"
                }
              },
              "required": [
                "createdAt"
              ]
            }
        """.trimIndent()
        )
    }
}