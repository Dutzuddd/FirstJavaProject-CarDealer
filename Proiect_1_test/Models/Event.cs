using System.ComponentModel.DataAnnotations;

namespace Proiect_1_test.Models
{
    public class Event
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public DateTime StartTime { get; set; }
        public DateTime EndTime { get; set; }

        public virtual Location Location { get; set; }
    }
}
